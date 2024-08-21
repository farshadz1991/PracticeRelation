package com.javatar.uni2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "studentCourse",
    joinColumns = @JoinColumn(name = "student_Id"),
            inverseJoinColumns = @JoinColumn(name = "course_Id"))
    private Set<Course> courses=new HashSet<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentDegree_Id")
    private StudentDegree studentDegree;

}
