package com.flumensistemas.course_evaluations.exception;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(Long id){
        super("El id '"+id+"' no existe en nuestros registros");
    }
}