package com.springboot.jpa.example;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTests {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseController courseController;

    @Test
    public void findCoursesCallsFindAll() {
        Course course = new Course("1", "Course 1", "Cource 1 Description");
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course));

        List<Course> response = courseController.find();

        assertThat(response, is(notNullValue()));
        assertThat(response.size(), is(1));
        assertThat(response, hasItem(course));
    }

    @Test
    public void createCourseCallsSave() {
        Course course = new Course("Course 1", "Cource 1 Description");
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course response = courseController.create(course);

        assertThat(response, is(notNullValue()));
        assertThat(response, is(course));
    }

    @Test
    public void updateCourseCallsSave() {
        Course course = new Course("Course 1", "Cource 1 Description");
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course response = courseController.update("1", course);

        assertThat(response, is(notNullValue()));
        assertThat(response, is(course));
    }

    @Test
    public void deleteCourseCallsDelete() {
        doNothing().when(courseRepository).delete("1");

        courseController.delete("1");

        verify(courseRepository).delete("1");
    }
}