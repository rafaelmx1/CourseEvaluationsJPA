package com.flumensistemas.course_evaluations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flumensistemas.course_evaluations.entity.Group;
import com.flumensistemas.course_evaluations.entity.Participant;
import com.flumensistemas.course_evaluations.service.GroupService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/course/{courseId}")
    public ResponseEntity<Group> saveGroup(@Valid @RequestBody Group group, @PathVariable Long courseId){
        return new ResponseEntity<>(groupService.saveGroup(group, courseId), HttpStatus.CREATED);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Group>> getGroup(@PathVariable Long courseId){
        return new ResponseEntity<>(groupService.getGroupByCourseId(courseId),HttpStatus.OK);
    }

    @PutMapping("/{groupId}/participant/{participantId}")
    public ResponseEntity<Group> enrollParticipantToGroup(@PathVariable Long groupId, @PathVariable Long participantId) {
        return new ResponseEntity<>(groupService.addParticipantToGroup(participantId, groupId),HttpStatus.OK);
    }

    @GetMapping("/{groupId}/participants")
    public ResponseEntity<Set<Participant>> getEnrolledParticipants(@PathVariable Long groupId) {
        return new ResponseEntity<>(groupService.getEnrolledParticipants(groupId),HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<HttpStatus> deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
