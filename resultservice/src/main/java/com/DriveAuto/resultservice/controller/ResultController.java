package com.DriveAuto.resultservice.controller;

import com.DriveAuto.resultservice.dto.ResultRequestDTO;
import com.DriveAuto.resultservice.dto.ResultResponseDTO;
import com.DriveAuto.resultservice.mapper.ResultMapper;
import com.DriveAuto.resultservice.model.Result;
import com.DriveAuto.resultservice.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {


    private ResultService resultService;
    private  ResultMapper resultMapper;

    public ResultController(ResultService resultService, ResultMapper resultMapper) {
        this.resultService = resultService;
        this.resultMapper = resultMapper;
    }

    @PostMapping
    public ResponseEntity<ResultResponseDTO> createResult(@RequestBody ResultRequestDTO requestDTO) {
        Result result = resultMapper.toEntity(requestDTO);
        Result savedResult = resultService.saveResult(result);
        return ResponseEntity.ok(resultMapper.toResponseDTO(savedResult));
    }

    @GetMapping
    public ResponseEntity<List<ResultResponseDTO>> getAllResults() {
        return ResponseEntity.ok(
                resultService.getAllResults().stream()
                        .map(resultMapper::toResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponseDTO> getResultById(@PathVariable Long id) {
        return resultService.getResultById(id)
                .map(result -> ResponseEntity.ok(resultMapper.toResponseDTO(result)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{utilisateurId}")
    public ResponseEntity<List<ResultResponseDTO>> getResultsByUtilisateurId(@PathVariable Long utilisateurId) {
        return ResponseEntity.ok(
                resultService.getResultsByUtilisateurId(utilisateurId).stream()
                        .map(resultMapper::toResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<ResultResponseDTO>> getResultsByQuizId(@PathVariable Long quizId) {
        return ResponseEntity.ok(
                resultService.getResultsByQuizId(quizId).stream()
                        .map(resultMapper::toResponseDTO)
                        .toList()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }
}
