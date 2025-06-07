package com.DriveAuto.fileservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadRequestDTO {
    @Schema(type = "string", format = "binary", description = "Fichier à uploader")
    private MultipartFile file;

    @Schema(example = "rapport-annuel.pdf", description = "Nom d'affichage du fichier")
    private String name;

    @Schema(example = "Rapport financier 2023", description = "Description metadata")
    private String description;

    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

