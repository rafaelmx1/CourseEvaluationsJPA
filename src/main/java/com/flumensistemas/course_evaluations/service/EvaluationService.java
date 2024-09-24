package com.flumensistemas.course_evaluations.service;

import com.flumensistemas.course_evaluations.entity.Evaluation;
import java.util.List;

public interface EvaluationService {

    Evaluation saveEvaluation(Evaluation evaluation);
    Evaluation getEvaluation(Long id);
    void deleteEvaluation(Long id);
    List<Evaluation> getEvaluations();
    Evaluation addPreguntaToEvaluacion(Long questionId,Long evaluationId);

}
