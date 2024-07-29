package com.betterschedular.controller;

import com.betterschedular.model.Course;
import com.betterschedular.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/ge/{GE}")
    public Iterable<Course> getCourseByGE(@PathVariable String GE) {
        return courseService.getCourseByGE(GE);
    }

    @GetMapping("/code/{code}")
    public Iterable<Course> getCourseByCode(@PathVariable String code) {
        return courseService.getCourseByCode(code);
    }

    @GetMapping("/Uid/{Uid}")
    public Optional<Course> getCourse(@PathVariable Integer Uid) {
        return courseService.getCourseById(Uid);
    }

    @GetMapping("/courseCodes")
    public Iterable<String> getCourseCodes() {
        return courseService.getCourseCodes();
    }

    @GetMapping("/semesters")
    public Iterable<String> getSemesters() {
        return courseService.getSemesters();
    }

    //put in other endpoints later

}