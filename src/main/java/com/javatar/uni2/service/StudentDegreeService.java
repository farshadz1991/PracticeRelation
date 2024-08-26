package com.javatar.uni2.service;

import com.javatar.uni2.model.StudentDegree;
import com.javatar.uni2.repository.StudentDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDegreeService {
    @Autowired
    private StudentDegreeRepository studentDegreeRepository;

    public List<StudentDegree> getAllStudentDegree() {
        return studentDegreeRepository.findAll();
    }

    public Optional<StudentDegree> getStudentDegree(int id) {
        return studentDegreeRepository.findById(id);
    }

    public StudentDegree insertStudentDegree(StudentDegree studentDegree) {
        return studentDegreeRepository.save(studentDegree);
    }

    public void deleteStudentDegree(int id) {
        studentDegreeRepository.deleteById(id);
    }

    public StudentDegree updateStudentDegree(StudentDegree studentDegree) {
        return studentDegreeRepository.save(studentDegree);
    }
}

