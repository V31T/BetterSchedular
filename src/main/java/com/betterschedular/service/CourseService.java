package com.betterschedular.service;

import com.betterschedular.model.Course;
import com.betterschedular.repository.CourseRepository;
import com.betterschedular.scraper.CourseScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class is used to save static data into database
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;



    //Named Queries @ service layer
    public List<Course> getCourseByGE(String ge) {
        return courseRepo.findCoursesByGE(ge);
    }
    public List<Course> getCourseByCode(String code) {
        return courseRepo.findCoursesByCode(code);
    }
    public List<String> getCourseCodes() {
        return courseRepo.findCourseCodes();
    }
    public List<String> getSemesters() {
        return courseRepo.findSemesters();
    }





    public void saveCourses() {
        List<Course> courses = CourseScraper.getFall2024Courses();
        courseRepo.saveAll(courses);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }
    public Optional<Course> getCourseById(Integer Uid) {
        return courseRepo.findById(Uid); //inherited from JPARepository
    }

}
