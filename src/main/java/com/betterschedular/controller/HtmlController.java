package com.betterschedular.controller;

import com.betterschedular.model.Course;
import com.betterschedular.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HtmlController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String index(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "index"; // Corresponds to src/main/resources/templates/index.html
    }

}
