package com.javatar.uni2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class CourseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @OneToMany(mappedBy = "courseType")
    private Set<Course> course = new HashSet<Course>();
    //1   nazari
    //2   amali
    // n

}
