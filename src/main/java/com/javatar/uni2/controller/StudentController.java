package com.javatar.uni2.controller;

import com.javatar.uni2.model.Student;
import com.javatar.uni2.repository.StudentRepository;
import com.javatar.uni2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
public List<Student> getStudents() {
      return studentService.getAllStudentsInuni();

}
@PostMapping
public Student addStudent(@RequestBody Student student) {
      return studentService.insertStudent(student);
}

@DeleteMapping("{id}")
public void deleteStudent(@PathVariable("id") Long id){
     studentService.deleteStudent(id);
}
@PutMapping("{id}")
public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        //first found it
    Student stu = studentService.getStudentById(id);
    if(stu != null){
        //set value
        //student new value
        //stu old value
        if(student.getName() != null){
            stu.setName(student.getName());
        }
         if(student.getEmail() != null){
            stu.setEmail(student.getEmail());
        }
        return studentService.updateStudent(stu);
    }
    else {
        return null;
    }
}
}
