package com.DriveAuto.quizservice.controller;

import com.DriveAuto.quizservice.dto.QuestionRequestDTO;
import com.DriveAuto.quizservice.dto.QuestionResponseDTO;
import com.DriveAuto.quizservice.mapper.QuestionMapper;
import com.DriveAuto.quizservice.model.Question;
import com.DriveAuto.quizservice.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private  QuestionService questionService;
    private QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO requestDTO) {
        Question question = questionMapper.toEntity(requestDTO);
        Question savedQuestion = questionService.saveQuestion(question);
        return ResponseEntity.ok(questionMapper.toResponseDTO(savedQuestion));
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions() {
        return ResponseEntity.ok(
                questionService.getAllQuestions().stream()
                        .map(questionMapper::toResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id)
                .map(q -> ResponseEntity.ok(questionMapper.toResponseDTO(q)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> updateQuestion(
            @PathVariable Long id,
            @RequestBody QuestionRequestDTO requestDTO
    ) {
        Question existingQuestion = questionService.getQuestionById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        questionMapper.updateFromDto(requestDTO, existingQuestion);
        Question updatedQuestion = questionService.updateQuestion(id, existingQuestion); // ID passé explicitement

        return ResponseEntity.ok(questionMapper.toResponseDTO(updatedQuestion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}