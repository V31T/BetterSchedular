package com.betterschedular.repository;

import com.betterschedular.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(name = "Course.getCourseByCode")
    List<Course> findCoursesByCode(@Param("code")String code);

    @Query(name = "Course.getCourseByGE")
    List<Course> findCoursesByGE(@Param("ge")String ge);

    @Query(name = "Course.getCourseCodes")
    List<String> findCourseCodes();

    @Query(name = "Course.getSemesters")
    List<String> findSemesters();

}
