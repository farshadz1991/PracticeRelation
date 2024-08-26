package com.javatar.uni2.controller;

import com.javatar.uni2.model.StudentDegree;
import com.javatar.uni2.service.StudentDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("studentDegree")
public class StudentDegreeController {
    @Autowired
    private StudentDegreeService studentDegreeService;

    @GetMapping
    public List<StudentDegree> getAllStudentDegrees() {
        return studentDegreeService.getAllStudentDegree();
    }

    @PostMapping
    public StudentDegree addStudentDegree(@RequestBody StudentDegree studentDegree) {
        return studentDegreeService.insertStudentDegree(studentDegree);
    }

    @DeleteMapping("{id}")
    public void deleteStudentDegree(@PathVariable("id") int id) {
        studentDegreeService.deleteStudentDegree(id);
    }

    @PutMapping("{id}")
    public StudentDegree updateStudentDegree(@PathVariable("id") int id, @RequestBody StudentDegree studentDegree) {
        Optional<StudentDegree> stDegree = studentDegreeService.getStudentDegree(id);
        if (stDegree.isPresent()) {
            if (studentDegree.getTitle() != null){
                studentDegree.getTitle();
            }
            return studentDegreeService.updateStudentDegree(studentDegree);
        } else
            return null;
    }
}
