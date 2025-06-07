package com.DriveAuto.quizservice.dto;

public record QuestionResponseDTO(
        Long id,
        String texte,
        String options,
        String reponseCorrecte,
        Long quizId
) {}
