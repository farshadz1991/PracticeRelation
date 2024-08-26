package com.javatar.uni2.controller;

import com.javatar.uni2.model.Course;
import com.javatar.uni2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.insertCourse(course);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.deleteCourseById(id);
    }

    @PutMapping("{id}")
    public Course updateCourse(@PathVariable("id") long id, @RequestBody Course course) {

        Optional<Course> course1 = courseService.getCourseById(id);
        if (course1.isPresent()) {
            if (course.getTitle() != null) {
                course.getTitle();
            }
            return courseService.updateCourse(course);
        } else
            return null;
    }


}

