package com.flumensistemas.course_evaluations.repository;

import org.springframework.data.repository.CrudRepository;

import com.flumensistemas.course_evaluations.entity.Course;

public interface CourseRepository extends CrudRepository<Course,Long> {

    
} 
