package com.example.MySQL.controllers;

import com.example.MySQL.repository.Repository;
import com.example.MySQL.api.request.Request;
import com.example.MySQL.api.response.Response;
import com.example.MySQL.model.Course;
import com.example.MySQL.model.Student;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final Repository repository;

    @PostMapping("/")
    public Boolean addCourse(@RequestBody Request request) {
        Course course = new Course();
        Student student = new Student();
        student.setName(request.getStudent());

        course.setName(request.getName());
        course.setStudent(student);


        if (course.getName() != null) {
            Response response = new Response();
            response.setResponse(true);
            repository.save(course);
            return response.isResponse();
        } else {
            Response responseTwo = new Response();
            responseTwo.setResponse(false);
            return responseTwo.isResponse();
        }
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Integer id) {
        Course course = repository.getCourseById(id);
        course.getStudent().getName();
        return "Name Course: ".concat(course.getName()).concat("\nName student: ").concat(course.getStudent().getName());
    }
}
