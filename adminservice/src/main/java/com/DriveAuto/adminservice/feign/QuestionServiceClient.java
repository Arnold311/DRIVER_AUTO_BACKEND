package com.DriveAuto.adminservice.feign;

import com.DriveAuto.adminservice.model.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "question-service")
public interface QuestionServiceClient {

    @PostMapping("/api/s3/questions")
    Question createQuestion(@RequestBody Question question);

    @GetMapping("/api/s3/questions")
    List<Question> getAllQuestions();

    @GetMapping("/api/s3/questions/{id}")
    Question getQuestionById(@PathVariable Long id);

    @PutMapping("/api/s3/questions/{id}")
    Question updateQuestion(@PathVariable Long id, @RequestBody Question question);

    @DeleteMapping("/api/s3/questions/{id}")
    void deleteQuestion(@PathVariable Long id);
}