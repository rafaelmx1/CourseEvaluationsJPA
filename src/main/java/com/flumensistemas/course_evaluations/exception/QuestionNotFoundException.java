package com.flumensistemas.course_evaluations.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(Long id){
        super("El id '"+id+"' no existe en nuestros registros");
    }
}
