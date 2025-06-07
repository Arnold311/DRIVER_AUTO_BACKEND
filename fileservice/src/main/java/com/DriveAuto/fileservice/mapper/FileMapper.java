package com.DriveAuto.fileservice.mapper;

import com.DriveAuto.fileservice.dto.FileResponseDTO;
import com.DriveAuto.fileservice.model.File;
import org.springframework.stereotype.Component;

@Component
public class FileMapper {
    public FileResponseDTO toResponseDTO(File file) {
        return new FileResponseDTO(
                file.getId(),
                file.getName(),
                file.getDescription(),
                file.getFilePath()
        );
    }
}
