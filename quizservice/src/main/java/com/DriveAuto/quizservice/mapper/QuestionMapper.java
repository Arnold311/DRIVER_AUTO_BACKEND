package com.DriveAuto.quizservice.mapper;

import com.DriveAuto.quizservice.dto.QuestionRequestDTO;
import com.DriveAuto.quizservice.dto.QuestionResponseDTO;
import com.DriveAuto.quizservice.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public Question toEntity(QuestionRequestDTO dto) {
        Question question = new Question();
        question.setTexte(dto.texte());
        question.setOptions(dto.options());
        question.setReponseCorrecte(dto.reponseCorrecte());
        question.setQuizId(dto.quizId());
        return question;
    }

    public QuestionResponseDTO toResponseDTO(Question entity) {
        return new QuestionResponseDTO(
                entity.getId(),
                entity.getTexte(),
                entity.getOptions(),
                entity.getReponseCorrecte(),
                entity.getQuizId()
        );
    }

    public void updateFromDto(QuestionRequestDTO dto, Question entity) {
        entity.setTexte(dto.texte());
        entity.setOptions(dto.options());
        entity.setReponseCorrecte(dto.reponseCorrecte());
        entity.setQuizId(dto.quizId());
    }
}
