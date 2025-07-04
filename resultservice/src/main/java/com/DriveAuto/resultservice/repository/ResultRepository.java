package com.DriveAuto.resultservice.repository;

import com.DriveAuto.resultservice.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByUtilisateurId(Long utilisateurId);
    List<Result> findByQuizId(Long quizId);
}
