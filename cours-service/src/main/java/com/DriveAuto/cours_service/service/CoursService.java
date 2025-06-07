package com.DriveAuto.cours_service.service;

import com.DriveAuto.cours_service.DTO.CoursRequestDTO;
import com.DriveAuto.cours_service.model.Cours;
;
import com.DriveAuto.cours_service.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    private  CourseRepository courseRepository;

    public CoursService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public Cours saveCourse(Cours course) {
        return courseRepository.save(course);
    }

    public List<Cours> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Cours> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Cours updateCourse(Long id, Cours courseDetails) {
        Cours course = courseRepository.findById(id).orElseThrow();
        course.setTitle(courseDetails.getTitle());
        course.setDescription(courseDetails.getDescription());
        course.setContent(courseDetails.getContent());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
