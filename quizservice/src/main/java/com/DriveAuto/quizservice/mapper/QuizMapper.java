package com.DriveAuto.quizservice.mapper;

import com.DriveAuto.quizservice.dto.QuizRequestDTO;
import com.DriveAuto.quizservice.dto.QuizResponseDTO;
import com.DriveAuto.quizservice.model.Quiz;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {

    public Quiz toEntity(QuizRequestDTO dto) {
        Quiz quiz = new Quiz();
        quiz.setTitle(dto.title());
        quiz.setDescription(dto.description());
        quiz.setCoursId(dto.coursId());
        return quiz;
    }

    public QuizResponseDTO toResponseDTO(Quiz entity) {
        return new QuizResponseDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCoursId()
        );
    }

    public void updateFromDto(QuizRequestDTO dto, Quiz entity) {
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setCoursId(dto.coursId());
    }
}