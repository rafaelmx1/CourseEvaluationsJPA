package com.flumensistemas.course_evaluations.service;

import com.flumensistemas.course_evaluations.entity.Group;
import com.flumensistemas.course_evaluations.entity.Participant;
import java.util.List;
import java.util.Set;

public interface ParticipantService {

    Participant saveParticipant(Participant participant);
    void deleteParticipant(Long id);
    Participant getParticipant(Long id);
    List<Participant> getParticipants();
    Set<Group> getEnrolledGroups(Long id);
    
}
