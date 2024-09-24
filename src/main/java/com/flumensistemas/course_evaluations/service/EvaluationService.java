package com.flumensistemas.course_evaluations.service;

import java.util.List;

import com.flumensistemas.course_evaluations.entity.Evaluation;

public interface EvaluationService {

    Evaluation saveEvaluation(Evaluation evaluation);
    Evaluation getEvaluation(Long id);
    void deleteEvaluation(Long id);
    List<Evaluation> getEvaluations();
    Evaluation addQuestionToEvaluation(Long questionId,Long evaluationId);

}
