package com.flumensistemas.course_evaluations.service;

import com.flumensistemas.course_evaluations.entity.Grade;
import java.util.List;

public interface GradeService {

    Grade saveGrade(Grade grade, Long participantId, Long evaluationId);
    Grade getGrade(Long participantId, Long evaluationId);
    Grade updateGrade(Double score, Long participantId, Long evaluationId);
    void deleteGrade(Long participantId, Long evaluationId);
    List<Grade> getParticipantGrades(Long participantId);
    List<Grade> getEvaluationGrades(Long evaluationId);
    List<Grade> getAllGrades();

}
