package com.example.MySQL.controllers;

import com.example.MySQL.Repository.Repository;
import com.example.MySQL.api.request.Request;
import com.example.MySQL.api.response.Response;
import com.example.MySQL.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final Repository repository;

    @PostMapping("/")
    public Boolean addCourse(@RequestBody Request request) {
        Course course = new Course();
        course.setName(request.getName());


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

    public void addStudent() {

    }
}
