package com.DriveAuto.quizservice.dto;

public record QuizRequestDTO(
        String title,
        String description,
        Long coursId
) {}
