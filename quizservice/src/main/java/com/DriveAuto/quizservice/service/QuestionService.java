package com.DriveAuto.quizservice.service;

import com.DriveAuto.quizservice.model.Question;
import com.DriveAuto.quizservice.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {


    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public Question updateQuestion(Long id, Question questionDetails) {
        if (!id.equals(questionDetails.getId())) {
            throw new IllegalArgumentException("ID non egale");
        }
        Question question = questionRepository.findById(id).orElseThrow();
        question.setTexte(questionDetails.getTexte());
        question.setOptions(questionDetails.getOptions());
        question.setReponseCorrecte(questionDetails.getReponseCorrecte());
        question.setQuizId(questionDetails.getQuizId());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}