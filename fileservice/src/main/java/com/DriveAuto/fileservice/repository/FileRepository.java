package com.DriveAuto.fileservice.repository;

import com.DriveAuto.fileservice.model.File;;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<File,String> {
}