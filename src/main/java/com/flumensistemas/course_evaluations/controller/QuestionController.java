package com.flumensistemas.course_evaluations.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flumensistemas.course_evaluations.entity.Question;
import com.flumensistemas.course_evaluations.service.QuestionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/question")
@RestController
public class QuestionController {

    QuestionService questionService;

    @PostMapping("/course/{courseId}/topic/{topicId}")
    public ResponseEntity<Question> saveQuestion(@Valid @RequestBody Question question, @PathVariable Long courseId,@PathVariable Long topicId){
        return new ResponseEntity<>(questionService.saveQuestion(question,courseId,topicId),HttpStatus.CREATED);
    }
    @DeleteMapping("/course/{courseId}/topic/{topicId}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable Long courseId,@PathVariable Long topicId){
        questionService.deleteQuestionByCourseIdAndTopicId(courseId,topicId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long id){
        return new ResponseEntity<>(questionService.getQuestion(id),HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Question>> getQuestions(){
        return new ResponseEntity<>(questionService.getQuestions(),HttpStatus.OK);
    }
    @GetMapping("/course/{courseId}/topic/{topicId}")
    public ResponseEntity<List<Question>> getQuestionByCourseIdAndTopicId(@PathVariable Long courseId, @PathVariable Long topicId){
        return new ResponseEntity<>(questionService.getQuestionsByCourseIdAndTopicId(courseId,topicId),HttpStatus.OK);
    }
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Question>> getQuestionByCourseId(@PathVariable Long courseId){
        return new ResponseEntity<>(questionService.getQuestionsByCourseId(courseId),HttpStatus.OK);
    }
    
}
