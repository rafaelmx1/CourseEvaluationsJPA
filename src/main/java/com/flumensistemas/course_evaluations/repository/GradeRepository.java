package com.flumensistemas.course_evaluations.repository;

import org.springframework.data.repository.CrudRepository;

import com.flumensistemas.course_evaluations.entity.Grade;

import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.List;

public interface GradeRepository extends CrudRepository<Grade,Long>{
    Optional<Grade> findByParticipantIdAndEvaluationId(Long participantId, Long evaluationId);
    @Transactional
    void deleteByParticipantIdAndEvaluationId(Long participantId, Long evaluatiionId);
    List<Grade> findByParticipantId(Long participantId);
    List<Grade> findByEvaluationId(Long evaluationId);
}
