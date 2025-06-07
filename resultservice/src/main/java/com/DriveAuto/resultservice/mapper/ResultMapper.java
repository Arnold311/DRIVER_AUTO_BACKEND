package com.DriveAuto.resultservice.mapper;

import com.DriveAuto.resultservice.dto.ResultRequestDTO;
import com.DriveAuto.resultservice.dto.ResultResponseDTO;
import com.DriveAuto.resultservice.model.Result;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ResultMapper {

    public Result toEntity(ResultRequestDTO dto) {
        Result result = new Result();
        result.setUtilisateurId(dto.utilisateurId());
        result.setQuizId(dto.quizId());
        result.setScore(dto.score());
        result.setDate(LocalDateTime.now());
        return result;
    }

    public ResultResponseDTO toResponseDTO(Result entity) {
        return new ResultResponseDTO(
                entity.getId(),
                entity.getUtilisateurId(),
                entity.getQuizId(),
                entity.getScore(),
                entity.getDate()
        );
    }

}
