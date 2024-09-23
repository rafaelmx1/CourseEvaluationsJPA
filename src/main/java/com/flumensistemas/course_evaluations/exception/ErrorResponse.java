package com.flumensistemas.course_evaluations.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
public class ErrorResponse {
    private List<String> message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;


    public ErrorResponse(List<String> message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }


}
