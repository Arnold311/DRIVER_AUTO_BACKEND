package com.DriveAuto.fileservice.controller;

import com.DriveAuto.fileservice.dto.FileResponseDTO;
import com.DriveAuto.fileservice.dto.FileUploadRequestDTO;
import com.DriveAuto.fileservice.mapper.FileMapper;
import com.DriveAuto.fileservice.model.File;
import com.DriveAuto.fileservice.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;
    private final FileMapper fileMapper;

    public FileController(FileService fileService, FileMapper fileMapper) {
        this.fileService = fileService;
        this.fileMapper = fileMapper;
    }

    @Operation(
            summary = "Uploader un fichier",
            description = "Téléverse un fichier avec métadonnées",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
                            schema = @Schema(implementation = FileUploadRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Fichier uploadé avec succès"),
                    @ApiResponse(responseCode = "400", description = "Format de requête invalide")
            }
    )
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileResponseDTO> uploadFile(
            @ModelAttribute FileUploadRequestDTO requestDTO) throws IOException {

        File savedFile = fileService.saveFile(requestDTO);
        return ResponseEntity.ok(fileMapper.toResponseDTO(savedFile));
    }



    @GetMapping
    public ResponseEntity<List<FileResponseDTO>> getAllFiles() {
        return ResponseEntity.ok(
                fileService.getAllFiles().stream()
                        .map(fileMapper::toResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileResponseDTO> getFileById(@PathVariable String id) {
        return fileService.getFileById(id)
                .map(file -> ResponseEntity.ok(fileMapper.toResponseDTO(file)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable String id) {
        fileService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }

    @Schema(description = "Payload pour l'upload de fichier")
    private static class FileUploadRequest {
        @Schema(type = "string", format = "binary", description = "Fichier à uploader")
        public MultipartFile file;

        @Schema(example = "rapport-annuel.pdf", description = "Nom d'affichage du fichier")
        public String name;

        @Schema(example = "Rapport financier 2023", description = "Description metadata")
        public String description;
    }
}
