package com.DriveAuto.resultservice.dto;

import java.time.LocalDateTime;

public record ResultResponseDTO(
        Long id,
        Long utilisateurId,
        Long quizId,
        Double score,
        LocalDateTime date
) {}
