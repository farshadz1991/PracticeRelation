package com.javatar.uni2.repository;

import com.javatar.uni2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
