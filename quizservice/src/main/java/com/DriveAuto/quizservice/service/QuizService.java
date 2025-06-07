package com.DriveAuto.quizservice.service;

import com.DriveAuto.quizservice.model.Quiz;
import com.DriveAuto.quizservice.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {


    private QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public Quiz updateQuiz(Long id, Quiz quizDetails) {
        if (!id.equals(quizDetails.getId())) {
            throw new IllegalArgumentException("ID non égale");
        }
        Quiz quiz = quizRepository.findById(id).orElseThrow();
        quiz.setTitle(quizDetails.getTitle());
        quiz.setDescription(quizDetails.getDescription());
        quiz.setCoursId(quizDetails.getCoursId());
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}