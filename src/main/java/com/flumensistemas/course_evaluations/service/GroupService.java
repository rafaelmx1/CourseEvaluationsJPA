package com.flumensistemas.course_evaluations.service;

import java.util.List;
import java.util.Set;

import com.flumensistemas.course_evaluations.entity.Group;
import com.flumensistemas.course_evaluations.entity.Participant;

public interface GroupService {

    Group saveGroup(Group group,Long courseId);
    List<Group> getGroupByCourseId(Long courseId);
    Group addParticipantToGroup(Long participantId,Long groupId);
    Group getGroup(Long groupId);
    void deleteGroup(Long groupId);
    Set<Participant> getEnrolledParticipants(Long id);
    
}
