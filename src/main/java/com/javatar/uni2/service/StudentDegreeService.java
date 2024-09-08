package com.javatar.uni2.service;

import com.javatar.uni2.model.Student;
import com.javatar.uni2.model.StudentDegree;
import com.javatar.uni2.repository.StudentDegreeRepository;
import com.javatar.uni2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDegreeService {
    @Autowired
    private StudentDegreeRepository studentDegreeRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDegree> getAllStudentDegree() {
        return studentDegreeRepository.findAll();
    }

    public Optional<StudentDegree> getStudentDegree(Long id) {
        return studentDegreeRepository.findById(id);
    }

    public StudentDegree insertStudentDegree(Long id,StudentDegree studentDegree) {
        try {
            Student student = studentRepository.findById(id).get();
            studentDegree.setStudent(student);
            return studentDegreeRepository.save(studentDegree);
        }
        catch (Exception ex)
        {

            return null;
        }

    }

    public void deleteStudentDegree(Long id) {
        studentDegreeRepository.deleteById(id);
    }

    public StudentDegree updateStudentDegree(StudentDegree studentDegree) {
        return studentDegreeRepository.save(studentDegree);
    }
}

