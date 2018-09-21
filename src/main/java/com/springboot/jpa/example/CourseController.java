package com.springboot.jpa.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> find() {
        return courseRepository.findAll();
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseRepository.save(new Course(course.getName(), course.getDescription()));
    }

    @PutMapping("/{courseId}")
    public Course update(@PathVariable String courseId, @RequestBody Course course) {
        return courseRepository.save(new Course(courseId, course.getName(), course.getDescription()));
    }

    @DeleteMapping("/{courseId}")
    public void delete(@PathVariable String courseId) {
        courseRepository.delete(courseId);
    }
}
