package com.javatar.uni2.controller;


import com.javatar.uni2.model.Course;
import com.javatar.uni2.model.Student;
import com.javatar.uni2.service.CourseService;
import com.javatar.uni2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("Enroll")
public class EnrollmentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;
    //1 yek func dashte bashim k name student ro begire
    //2 va biyare

    //3 ID course ro begirim
    //4 dars ro biyarim
    //5 insert konim

    @PostMapping("studentName/{student_name}/courseID/{course_id}")
    public boolean EnrollmentSave(@PathVariable(value = "student_name") String studentname,@PathVariable(value = "course_id") Long course_id){

       try{
           Student student=studentService.getStudentByName(studentname);
           if(student!=null)
           {
               Course course=courseService.getCourseById(course_id);
               if(course!=null)
               {

                   Set<Course> courses=new HashSet<>();
                   courses.add(course);

                   student.setCourses(courses);

                   studentService.updateStudent(student);

                   return true;
               }
               else
               {
                   return false;
               }

           }
           else {
               return false;

           }
       }
           catch (Exception ex)
           {
               return false;

           }

    }

}
