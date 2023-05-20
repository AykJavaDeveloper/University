package com.example.MySQL.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;


}
