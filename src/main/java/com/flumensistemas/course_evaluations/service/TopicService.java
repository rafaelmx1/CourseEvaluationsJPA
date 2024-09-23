package com.flumensistemas.course_evaluations.service;

import java.util.List;
import com.flumensistemas.course_evaluations.entity.Topic;

public interface TopicService {

    Topic saveTopic(Topic topic);
    Topic saveTopic(Topic topic, Long courseId);
    void deleteTopic(Long id);
    Topic getTopic(Long id);
    List<Topic> getTopicsByCourseId(Long courseId);
    List<Topic> getTopics();
    
}
