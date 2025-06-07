package com.DriveAuto.quizservice.controller;

import com.DriveAuto.quizservice.dto.QuizRequestDTO;
import com.DriveAuto.quizservice.dto.QuizResponseDTO;
import com.DriveAuto.quizservice.mapper.QuizMapper;
import com.DriveAuto.quizservice.model.Quiz;
import com.DriveAuto.quizservice.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizzes")

public class QuizController {

    private QuizService quizService;
    private  QuizMapper quizMapper;

    public QuizController(QuizService quizService, QuizMapper quizMapper) {
        this.quizService = quizService;
        this.quizMapper = quizMapper;
    }

    @PostMapping
    public ResponseEntity<QuizResponseDTO> createQuiz(@RequestBody QuizRequestDTO requestDTO) {
        Quiz quiz = quizMapper.toEntity(requestDTO);
        Quiz savedQuiz = quizService.saveQuiz(quiz);
        return ResponseEntity.ok(quizMapper.toResponseDTO(savedQuiz));
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDTO>> getAllQuizzes() {
        return ResponseEntity.ok(
                quizService.getAllQuizzes().stream()
                        .map(quizMapper::toResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id)
                .map(q -> ResponseEntity.ok(quizMapper.toResponseDTO(q)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> updateQuiz(
            @PathVariable Long id,
            @RequestBody QuizRequestDTO requestDTO
    ) {
        Quiz existingQuiz = quizService.getQuizById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        quizMapper.updateFromDto(requestDTO, existingQuiz);
        Quiz updatedQuiz = quizService.updateQuiz(id, existingQuiz);

        return ResponseEntity.ok(quizMapper.toResponseDTO(updatedQuiz));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
