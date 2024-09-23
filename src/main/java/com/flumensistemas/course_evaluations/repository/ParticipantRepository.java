package com.flumensistemas.course_evaluations.repository;

import org.springframework.data.repository.CrudRepository;

import com.flumensistemas.course_evaluations.entity.Participant;

public interface ParticipantRepository extends CrudRepository<Participant,Long> {

    
}
