package com.DriveAuto.fileservice.service;

import com.DriveAuto.fileservice.dto.FileUploadRequestDTO;
import com.DriveAuto.fileservice.model.File;
import com.DriveAuto.fileservice.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveFile(FileUploadRequestDTO requestDTO) {
        String filePath = "/uploads/" + requestDTO.getFile().getOriginalFilename();

        File file = new File();
        file.setName(requestDTO.getName());
        file.setDescription(requestDTO.getDescription());
        file.setFilePath(filePath);

        return fileRepository.save(file);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public Optional<File> getFileById(String id) {
        return fileRepository.findById(id);
    }

    public void deleteFile(String id) {
        fileRepository.deleteById(id);
    }
}



