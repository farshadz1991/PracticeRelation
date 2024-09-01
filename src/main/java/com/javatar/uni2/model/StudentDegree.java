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
    @MapsId
    @JoinColumn(name = "student_id")
    private Student student;


}
