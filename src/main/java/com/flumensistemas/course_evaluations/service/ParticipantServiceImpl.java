package com.flumensistemas.course_evaluations.service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Group;
import com.flumensistemas.course_evaluations.entity.Participant;
import com.flumensistemas.course_evaluations.exception.ParticipantNotFoundException;
import com.flumensistemas.course_evaluations.repository.ParticipantRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ParticipantServiceImpl implements ParticipantService {

    ParticipantRepository participantRepository;

    @Override
    public Participant saveParticipant(Participant participant){
        return participantRepository.save(participant);
    }
    @Override
    public void deleteParticipant(Long id){
        participantRepository.deleteById(id);
    }
    @Override
    public Participant getParticipant(Long id) {
        Optional<Participant> participant = participantRepository.findById(id);
        return unwrapParticipant(participant, id);
    }
    @Override
    public List<Participant> getParticipants() {
        return (List<Participant>) participantRepository.findAll();
    }

    @Override
    public Set<Group> getEnrolledGroups(Long id){
        Participant participant = getParticipant(id);
        return participant.getGroups();
    }

    static Participant unwrapParticipant(Optional<Participant> entity,Long id){
        if(entity.isPresent()) return entity.get();
        else throw new ParticipantNotFoundException(id);
    }

    
}
