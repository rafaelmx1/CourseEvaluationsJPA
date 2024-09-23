package com.flumensistemas.course_evaluations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flumensistemas.course_evaluations.entity.Grade;
import com.flumensistemas.course_evaluations.service.GradeService;

import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/participant/{participantId}/evaluation/{evaluationId}")
    public ResponseEntity<Grade> saveGrade(@Valid @RequestBody Grade grade, @PathVariable Long participantId, @PathVariable Long evaluationId){
        return new ResponseEntity<>(gradeService.saveGrade(grade, participantId, evaluationId),HttpStatus.CREATED);
    }

    @GetMapping("/participant/{participantId}/evaluation/{evaluationId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long participantId, @PathVariable Long evaluationId){
        return new ResponseEntity<>(gradeService.getGrade(participantId, evaluationId),HttpStatus.OK);
    }

    @PutMapping("/participant/{participantId}/evaluation/{evaluationId}")
    public ResponseEntity<Grade> updateGrade(@Valid @RequestBody Grade grade, @PathVariable Long participantId, @PathVariable Long evaluationId){
        return new ResponseEntity<>(gradeService.updateGrade(grade.getScore(), participantId, evaluationId),HttpStatus.CREATED);
    }

    @DeleteMapping("/participant/{participantId}/evaluation/{evaluationId}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long participantId, @PathVariable Long evaluationId){
        gradeService.deleteGrade(participantId, evaluationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/participant/{participantId}")
    public ResponseEntity<List<Grade>> getParticipantGrades(@PathVariable Long participantId){
        return new ResponseEntity<>(gradeService.getParticipantGrades(participantId),HttpStatus.OK);
    }

    @GetMapping("/evaluation/{evaluationId}")
    public ResponseEntity<List<Grade>> getEvaluationGrades(@PathVariable Long evaluationId){
        return new ResponseEntity<>(gradeService.getEvaluationGrades(evaluationId),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(gradeService.getAllGrades(),HttpStatus.OK);
    }


}
