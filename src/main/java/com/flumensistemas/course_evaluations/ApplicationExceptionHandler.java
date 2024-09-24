package com.flumensistemas.course_evaluations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.flumensistemas.course_evaluations.exception.CourseNotFoundException;
import com.flumensistemas.course_evaluations.exception.ErrorResponse;
import com.flumensistemas.course_evaluations.exception.EvaluationNotFoundException;
import com.flumensistemas.course_evaluations.exception.GradeNotFoundException;
import com.flumensistemas.course_evaluations.exception.ParticipantNotFoundException;
import com.flumensistemas.course_evaluations.exception.QuestionNotFoundException;
import com.flumensistemas.course_evaluations.exception.TopicNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EvaluationNotFoundException.class,   GradeNotFoundException.class, 
                        CourseNotFoundException.class, ParticipantNotFoundException.class, 
                       QuestionNotFoundException.class, TopicNotFoundException.class})

    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex){
        ErrorResponse errorResponse = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                List<String> errors = new ArrayList<>();
                for (ObjectError error : ex.getBindingResult().getAllErrors()) {
                    errors.add(error.getDefaultMessage());
                }
        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.BAD_REQUEST);
    }
    

}