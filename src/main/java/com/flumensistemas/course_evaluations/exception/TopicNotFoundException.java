package com.flumensistemas.course_evaluations.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(Long id){
        super("El id '"+id+"' no existe en nuestros registros");
    }
}
