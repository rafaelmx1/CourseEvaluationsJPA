package com.flumensistemas.course_evaluations.service;

import com.flumensistemas.course_evaluations.entity.Course;
import java.util.List;

public interface CourseService {

    Course saveCourse(Course course);
    Course getCourse(Long id);
    void deleteCourse(Long id);
    List<Course> getCourses();
    Course updateCourse(Long courseId, String courseName, String courseStatus);
    
}
