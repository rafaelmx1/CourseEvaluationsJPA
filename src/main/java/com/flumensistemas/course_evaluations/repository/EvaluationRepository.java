package com.flumensistemas.course_evaluations.repository;

import org.springframework.data.repository.CrudRepository;

import com.flumensistemas.course_evaluations.entity.Evaluation;

public interface EvaluationRepository extends CrudRepository<Evaluation, Long> {

}
