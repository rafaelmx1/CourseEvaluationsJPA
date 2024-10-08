package com.flumensistemas.course_evaluations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.flumensistemas.course_evaluations.entity.Course;
import com.flumensistemas.course_evaluations.service.CourseService;

import jakarta.validation.Valid;





@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseService.getCourse(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(courseService.getCourses(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course, @PathVariable Long id){
        return new ResponseEntity<>(courseService.updateCourse(id,course.getCourseName(),course.getCourseStatus()),HttpStatus.OK);
    }

    
}
