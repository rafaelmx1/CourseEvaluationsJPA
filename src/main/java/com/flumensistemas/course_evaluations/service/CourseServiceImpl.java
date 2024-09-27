package com.flumensistemas.course_evaluations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Course;
import com.flumensistemas.course_evaluations.exception.CourseNotFoundException;
import com.flumensistemas.course_evaluations.repository.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourse(Long course_id) {
        Optional<Course> course = courseRepository.findById(course_id);
        return unwrapCourse(course, course_id);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Long courseId, String courseName, String courseStatus){
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()) {
            Course unwrappedCourse = course.get();
            unwrappedCourse.setCourseName(courseName);
            unwrappedCourse.setCourseStatus(courseStatus);
            return courseRepository.save(unwrappedCourse);
        } else {
            throw new CourseNotFoundException(courseId);
        }
    }

    static Course unwrapCourse(Optional<Course> entity,Long id){
        if(entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id); 
    }    

    

    
}
