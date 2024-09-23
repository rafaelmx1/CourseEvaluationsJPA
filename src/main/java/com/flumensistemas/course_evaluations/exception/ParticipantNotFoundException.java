package com.flumensistemas.course_evaluations.exception;

public class ParticipantNotFoundException extends RuntimeException {
    public ParticipantNotFoundException(Long id){
        super("El id '"+id+"' no existe en nuestros registros");
    }
}
