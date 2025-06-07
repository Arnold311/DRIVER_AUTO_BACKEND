package com.DriveAuto.adminservice.feign;

import com.DriveAuto.adminservice.model.Cours;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "course-service")
public interface CourServiceClient {

    @PostMapping("/api/s2/cours")
    Cours createCourse(@RequestBody Cours cours);

    @GetMapping("/api/s2/cours")
    List<Cours> getAllCourses();

    @GetMapping("/api/s2/cours/{id}")
    Cours getCourseById(@PathVariable Long id);

    @PutMapping("/api/s2/cours/{id}")
    Cours updateCourse(@PathVariable Long id, @RequestBody Cours course);

    @DeleteMapping("/api/s2/cours/{id}")
    void deleteCourse(@PathVariable Long id);
}