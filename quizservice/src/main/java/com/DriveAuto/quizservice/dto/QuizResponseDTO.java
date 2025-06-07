package com.DriveAuto.quizservice.dto;

public record QuizResponseDTO(
        Long id,
        String title,
        String description,
        Long coursId
) {}
