package com.javatar.uni2.service;

import com.javatar.uni2.model.Student;
import com.javatar.uni2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudentsInuni() {
        return studentRepository.findAll();
    }
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }


    public Student getStudentByName(String studentName){
        return studentRepository.getStudentByName(studentName);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}

