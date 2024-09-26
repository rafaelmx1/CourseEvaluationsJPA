package com.flumensistemas.course_evaluations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Evaluation;
import com.flumensistemas.course_evaluations.entity.Topic;
import com.flumensistemas.course_evaluations.exception.EvaluationNotFoundException;
import com.flumensistemas.course_evaluations.repository.EvaluationRepository;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    public Evaluation saveEvaluation(Evaluation evaluation){
        Topic topic = new Topic();
        topic.setId(1L);
        evaluation.setTopic(topic);
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation getEvaluation(Long id){
        Optional<Evaluation> evaluation = evaluationRepository.findById(id);
        if(evaluation.isPresent()){
            return evaluation.get();
        } else {
            throw new EvaluationNotFoundException(id);
        }
    }

    @Override
    public void deleteEvaluation(Long id){
        evaluationRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> getEvaluations(){
        return (List<Evaluation>) evaluationRepository.findAll();
    }

    @Override
    public Evaluation addQuestionToEvaluation(Long questionId, Long evaluationId) {
        return null;
    }

    static Evaluation unwrapEvaluation(Optional<Evaluation> entity,Long id){
        if(entity.isPresent()) return entity.get();
        else throw new EvaluationNotFoundException(id);
    }

}
