package com.flumensistemas.course_evaluations.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Course;
import com.flumensistemas.course_evaluations.entity.Group;
import com.flumensistemas.course_evaluations.entity.Participant;
import com.flumensistemas.course_evaluations.exception.GroupNotFoundException;
import com.flumensistemas.course_evaluations.repository.CourseRepository;
import com.flumensistemas.course_evaluations.repository.GroupRepository;
import com.flumensistemas.course_evaluations.repository.ParticipantRepository;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ParticipantRepository participantRepository;

    @Override
    public Group getGroup(Long groupId) {
        Optional<Group> group = groupRepository.findById(groupId); 
        return unwrapGroup(group, groupId);
    }

    @Override
    public Group  saveGroup(Group group, Long courseId) {        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            group.setCourse(course.get());
            return groupRepository.save(group);
        } else {
            throw new GroupNotFoundException(courseId);
        }
    }

    @Override
    public List<Group> getGroupByCourseId(Long course_Id) {
        return groupRepository.findByCourseId(course_Id);
    }

    @Override
    public Group addParticipantToGroup(Long participantId, Long groupId) {
        Group group = getGroup(groupId);
        Optional<Participant> participant =  participantRepository.findById(participantId);
        Participant unwrappedParticipant = ParticipantServiceImpl.unwrapParticipant(participant, participantId);
        group.getParticipants().add(unwrappedParticipant);
        return groupRepository.save(group);
    }

    @Override
    public Set<Participant> getEnrolledParticipants(Long id) {
        Group group = getGroup(id);
        return group.getParticipants();
    }

    @Override
    public void deleteGroup(Long groupId){
        groupRepository.deleteById(groupId);
    }

    static Group unwrapGroup(Optional<Group> entity,Long id){
        if(entity.isPresent()) return entity.get();
        else throw new GroupNotFoundException(id);
    }

    
    
}
