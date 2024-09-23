package com.flumensistemas.course_evaluations.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id){
        super("Id '"+id+"' does not exist in our records");
    }
}
