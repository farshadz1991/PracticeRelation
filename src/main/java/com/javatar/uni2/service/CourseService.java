package com.javatar.uni2.service;

import com.javatar.uni2.model.Course;
import com.javatar.uni2.model.CourseType;
import com.javatar.uni2.repository.CourseRepository;
import com.javatar.uni2.repository.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course insertCourse(Long id,Course course) {
        CourseType courseType = courseTypeRepository.findById(id).get();
        course.setCourseType(courseType);
        return courseRepository.save(course);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

}

