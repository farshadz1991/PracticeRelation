package com.javatar.uni2.service;

import com.javatar.uni2.model.CourseType;
import com.javatar.uni2.repository.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseTypeService {
    @Autowired
    private CourseTypeRepository courseTypeRepository;

    public List<CourseType> getAllCourseTypes() {
        return courseTypeRepository.findAll();
    }

    public CourseType getCourseTypeById(long id) {
        return courseTypeRepository.findById(id).get();
    }

    public CourseType insertCourseType(CourseType courseType) {
        return courseTypeRepository.save(courseType);

    }

    public void deleteCourseType(Long id) {
        courseTypeRepository.deleteById(id);
    }

    public CourseType updateCourseType(CourseType courseType) {
        return courseTypeRepository.save(courseType);
    }
}
