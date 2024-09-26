package com.flumensistemas.course_evaluations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Evaluation;
import com.flumensistemas.course_evaluations.entity.Grade;
import com.flumensistemas.course_evaluations.entity.Participant;
import com.flumensistemas.course_evaluations.exception.GradeNotFoundException;
import com.flumensistemas.course_evaluations.repository.EvaluationRepository;
import com.flumensistemas.course_evaluations.repository.GradeRepository;
import com.flumensistemas.course_evaluations.repository.ParticipantRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    ParticipantRepository participantRepository;
    EvaluationRepository evaluationRepository;


    @Override
    public Grade saveGrade(Grade grade, Long participantId, Long evaluationId) {
        Evaluation evaluation = EvaluationServiceImpl.unwrapEvaluation(evaluationRepository.findById(evaluationId),evaluationId);
        Participant participant = ParticipantServiceImpl.unwrapParticipant(participantRepository.findById(participantId),participantId);
        grade.setParticipant(participant);
        grade.setEvaluation(evaluation);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade getGrade(Long participantId, Long evaluationId) {
        Optional<Grade> grade = gradeRepository.findByParticipantIdAndEvaluationId(participantId,evaluationId);
        return unwrapGrade(grade, participantId, evaluationId);
    }

    @Override
    public Grade updateGrade(Double score, Long participantId, Long evaluationId){
        Optional<Grade> grade = gradeRepository.findByParticipantIdAndEvaluationId(participantId, evaluationId);
        Grade unwrappedGrade = unwrapGrade(grade, participantId, evaluationId);
        unwrappedGrade.setScore(score);
        return gradeRepository.save(unwrappedGrade);
    }

    @Override
    public void deleteGrade(Long participantId, Long evaluationId) {
        gradeRepository.deleteByParticipantIdAndEvaluationId(participantId,evaluationId);
        
    }

    @Override
    public List<Grade> getParticipantGrades(Long participantId) {
        return gradeRepository.findByParticipantId(participantId);
    }

    @Override
    public List<Grade> getEvaluationGrades(Long evaluationId) {
        return gradeRepository.findByEvaluationId(evaluationId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }

    
    static Grade unwrapGrade(Optional<Grade> entity,Long participantId,Long evaluationId){
        if(entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(participantId,evaluationId); 
    }   


}
