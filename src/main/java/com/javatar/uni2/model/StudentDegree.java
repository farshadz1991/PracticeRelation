package com.javatar.uni2.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudentDegree {

    @Id
    private int id;
    private String title;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_Id")
    private Student student;



}
