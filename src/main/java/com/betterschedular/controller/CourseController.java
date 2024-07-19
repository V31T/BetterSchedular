package com.betterschedular.controller;

import com.betterschedular.model.Course;
import com.betterschedular.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public void addCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    //put in other endpoints later

}
