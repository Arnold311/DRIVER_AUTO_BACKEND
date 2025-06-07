package com.DriveAuto.cours_service.repository;

import com.DriveAuto.cours_service.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Cours, Long>{
}
