package com.DriveAuto.adminservice.feign;


import com.DriveAuto.adminservice.model.Quiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "quiz-service")
public interface QuizServiceClient {

    @PostMapping("/api/s3/quizzes")
    Quiz createQuiz(@RequestBody Quiz quiz);

    @GetMapping("/api/s3/quizzes")
    List<Quiz> getAllQuizzes();

    @GetMapping("/api/s3/quizzes/{id}")
    Quiz getQuizById(@PathVariable Long id);

    @PutMapping("/api/s3/quizzes/{id}")
    Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz);

    @DeleteMapping("/api/s3/quizzes/{id}")
    void deleteQuiz(@PathVariable Long id);
}