package com.example.MySQL.Repository;

import com.example.MySQL.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Course, Integer> {
}
