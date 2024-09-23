package com.flumensistemas.course_evaluations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.flumensistemas.course_evaluations.entity.Evaluation;
import com.flumensistemas.course_evaluations.service.EvaluationService;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<Evaluation> saveEvaluation(@RequestBody Evaluation evaluation){
        return new ResponseEntity<>(evaluationService.saveEvaluation(evaluation),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluation(@PathVariable Long id){
        return new ResponseEntity<>(evaluationService.getEvaluation(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEvaluation(@PathVariable Long id){
        evaluationService.deleteEvaluation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Evaluation>> getEvaluations(){
        return new ResponseEntity<>(evaluationService.getEvaluations(),HttpStatus.OK);
    }

}
