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


import com.flumensistemas.course_evaluations.entity.Topic;
import com.flumensistemas.course_evaluations.service.TopicService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/topic")
@RestController
public class TopicController {

    TopicService topicService;

    @PostMapping("/course/{courseId}")
    public ResponseEntity<Topic> saveTopic(@Valid @RequestBody Topic topic,@PathVariable Long courseId){
        return new ResponseEntity<>(topicService.saveTopic(topic,courseId),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable Long id){
        return new ResponseEntity<>(topicService.getTopic(id),HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Topic>> getTopicByCourseId(@PathVariable Long courseId){
        return new ResponseEntity<>(topicService.getTopicsByCourseId(courseId),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Topic>> getTopics(){
        return new ResponseEntity<>(topicService.getTopics(),HttpStatus.OK);
    }

}
