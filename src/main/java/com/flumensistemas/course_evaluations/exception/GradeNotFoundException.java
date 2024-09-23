package com.flumensistemas.course_evaluations.exception;

public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(Long participantId, Long evaluationId){
        super("Does not exist in our records");
    }
}
