package com.flumensistemas.course_evaluations.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score,Double>{

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value == null) return false;
        if (value.doubleValue()<0 || value.doubleValue()>10) return false;
        return true;
    }
    
}
