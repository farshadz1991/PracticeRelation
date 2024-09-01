package com.javatar.uni2.repository;

import com.javatar.uni2.model.Course;
import com.javatar.uni2.model.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseTypeId(Long id);
}
