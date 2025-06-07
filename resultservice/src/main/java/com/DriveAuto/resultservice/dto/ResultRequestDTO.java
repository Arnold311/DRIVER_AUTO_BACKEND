package com.DriveAuto.resultservice.dto;

public record ResultRequestDTO(
        Long utilisateurId,
        Long quizId,
        Double score
) {}