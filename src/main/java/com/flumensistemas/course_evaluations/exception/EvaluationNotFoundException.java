package com.flumensistemas.course_evaluations.exception;

public class EvaluationNotFoundException extends RuntimeException {
    public EvaluationNotFoundException(Long id){
        super("Id '"+id+"' does not exist in our records");
    }
}
