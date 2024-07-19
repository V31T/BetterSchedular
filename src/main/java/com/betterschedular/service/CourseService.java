package com.betterschedular.service;

import com.betterschedular.model.Course;
import com.betterschedular.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class is used to save static data into database
 */
@Service
    public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    public void saveCourse(Course course) {
        List<Course> courses = Scraper.getFall2024Courses();
        courseRepo.saveAll(courses);
    }
}
