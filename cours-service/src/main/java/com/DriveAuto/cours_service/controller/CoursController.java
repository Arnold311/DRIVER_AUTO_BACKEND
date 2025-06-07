package com.DriveAuto.cours_service.controller;

import com.DriveAuto.cours_service.DTO.CoursRequestDTO;
import com.DriveAuto.cours_service.DTO.CoursResponseDTO;
import com.DriveAuto.cours_service.mapper.CoursMapper;
import com.DriveAuto.cours_service.model.Cours;
import com.DriveAuto.cours_service.service.CoursService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursService courseService;
    private final CoursMapper coursMapper;

    public CoursController(CoursService courseService, CoursMapper coursMapper) {
        this.courseService = courseService;
        this.coursMapper = coursMapper;
    }

    @PostMapping
    public ResponseEntity<CoursResponseDTO> createCourse(@RequestBody CoursRequestDTO requestDTO) {
        Cours cours = coursMapper.toEntity(requestDTO);
        Cours savedCourse = courseService.saveCourse(cours);
        return ResponseEntity.ok(coursMapper.toResponseDTO(savedCourse));
    }

    @GetMapping
    public ResponseEntity<List<CoursResponseDTO>> getAllCourses() {
        return ResponseEntity.ok(
                courseService.getAllCourses().stream()
                        .map(coursMapper::toResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursResponseDTO> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(c -> ResponseEntity.ok(coursMapper.toResponseDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursResponseDTO> updateCourse(
            @PathVariable Long id,
            @RequestBody CoursRequestDTO requestDTO
    ) {
        Cours coursDetails = coursMapper.toEntity(requestDTO);
        Cours updatedCourse = courseService.updateCourse(id, coursDetails);
        return ResponseEntity.ok(coursMapper.toResponseDTO(updatedCourse));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
