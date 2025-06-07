package com.DriveAuto.resultservice.service;

import com.DriveAuto.resultservice.model.Result;
import com.DriveAuto.resultservice.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {


    private ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Result saveResult(Result result) {

        return resultRepository.save(result);
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Optional<Result> getResultById(Long id) {
        return resultRepository.findById(id);
    }

    public List<Result> getResultsByUtilisateurId(Long utilisateurId) {
        return resultRepository.findByUtilisateurId(utilisateurId);
    }

    public List<Result> getResultsByQuizId(Long quizId) {
        return resultRepository.findByQuizId(quizId);
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }

}