package com.DriveAuto.quizservice.dto;

public record QuestionRequestDTO(
        String texte,
        String options,
        String reponseCorrecte,
        Long quizId
) {}