package com.DriveAuto.fileservice.dto;

public record FileResponseDTO(
        String id,
        String name,
        String description,
        String filePath
) {}
