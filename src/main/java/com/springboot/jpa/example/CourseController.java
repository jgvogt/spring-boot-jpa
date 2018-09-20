package com.springboot.jpa.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> findCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(new Course(course.getName(), course.getDescription()));
    }

    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable String courseId, @RequestBody Course course) {
        return courseRepository.save(new Course(courseId, course.getName(), course.getDescription()));
    }
}
