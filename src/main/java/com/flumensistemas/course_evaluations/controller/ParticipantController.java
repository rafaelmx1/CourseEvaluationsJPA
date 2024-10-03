package com.flumensistemas.course_evaluations.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flumensistemas.course_evaluations.entity.Participant;
import com.flumensistemas.course_evaluations.entity.Group;
import com.flumensistemas.course_evaluations.service.ParticipantService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/participant")
@RestController
@CrossOrigin(origins = "*")
public class ParticipantController {

    ParticipantService participantService;

    @PostMapping
    public ResponseEntity<Participant> saveParticipant(@Valid @RequestBody Participant participant){
        return new ResponseEntity<>(participantService.saveParticipant(participant),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteParticipant(@PathVariable Long id){
        participantService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipant(@PathVariable Long id){
        return new ResponseEntity<>(participantService.getParticipant(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Participant>> getParticipants(){
        return new ResponseEntity<>(participantService.getParticipants(),HttpStatus.OK);
    }

    @GetMapping("/{id}/groups")
    public ResponseEntity<Set<Group>> getEnrolledGroups(@PathVariable Long id){
        return new ResponseEntity<>(participantService.getEnrolledGroups(id),HttpStatus.OK);
    }
    
}
