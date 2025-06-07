package com.DriveAuto.cours_service.mapper;

import com.DriveAuto.cours_service.DTO.CoursRequestDTO;
import com.DriveAuto.cours_service.DTO.CoursResponseDTO;
import com.DriveAuto.cours_service.model.Cours;
import org.springframework.stereotype.Component;

@Component
public class CoursMapper {

    public Cours toEntity(CoursRequestDTO dto) {
        Cours cours = new Cours();
        cours.setTitle(dto.title());
        cours.setDescription(dto.description());
        cours.setContent(dto.content());
        return cours;
    }

    public CoursResponseDTO toResponseDTO(Cours entity) {
        return new CoursResponseDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getContent()
        );
    }

    public void updateFromDto(CoursRequestDTO dto, Cours entity) {
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setContent(dto.content());
    }

}
