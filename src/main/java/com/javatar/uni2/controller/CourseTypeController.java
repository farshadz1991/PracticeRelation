package com.javatar.uni2.controller;

import com.javatar.uni2.model.Course;
import com.javatar.uni2.model.CourseType;
import com.javatar.uni2.repository.CourseRepository;
import com.javatar.uni2.repository.CourseTypeRepository;
import com.javatar.uni2.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courseType")
public class CourseTypeController {
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private CourseTypeRepository courseTypeRepository;
    @Autowired
    private CourseRepository courseRepository;
    //  @Autowired
  //  private CourseService courseService;

    @GetMapping
    public List<CourseType> getAllCourseTypes() {
        return courseTypeService.getAllCourseTypes();
    }

    @PostMapping
    public CourseType addCourseType(@RequestBody CourseType courseType) {
        return courseTypeService.insertCourseType(courseType);
    }

    @DeleteMapping("{id}")
    public void deleteCourseType(@PathVariable("id") long id) {
        courseTypeService.deleteCourseType(id);
    }

    @PutMapping("{id}")
    public CourseType updateCourseType(@PathVariable("id") long id, @RequestBody CourseType courseType) {
        CourseType courseType1 = courseTypeService.getCourseTypeById(id);
        if (courseType1 != null) {
            if (courseType.getTitle() != null) {
               courseType1.setTitle(courseType.getTitle());
            }
            return courseTypeService.updateCourseType(courseType1);
        } else
            return null;


    }

    @GetMapping("{id}/course")
    public List<Course> getAllCourses(@PathVariable("id") long id) {
        return courseRepository.findByCourseTypeId(id);
    }
}