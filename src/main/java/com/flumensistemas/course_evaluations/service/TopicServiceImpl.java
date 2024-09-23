package com.flumensistemas.course_evaluations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Course;
import com.flumensistemas.course_evaluations.entity.Topic;
import com.flumensistemas.course_evaluations.exception.TopicNotFoundException;
import com.flumensistemas.course_evaluations.repository.CourseRepository;
import com.flumensistemas.course_evaluations.repository.TopicRepository;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    TopicRepository topicRepository;
    CourseRepository courseRepository;

    @Override
    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }
    @Override
    public Topic saveTopic(Topic topic,Long courseId){
        Course course = courseRepository.findById(courseId).get();
        topic.setCourse(course);
        return topicRepository.save(topic);
    }
    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
    @Override
    public Topic getTopic(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        return unwrapTopic(topic, id);
    }
    @Override
    public List<Topic> getTopicsByCourseId(Long courseId) {
        return (List<Topic>) topicRepository.findByCourseId(courseId);
    }
    @Override
    public List<Topic> getTopics() {
        return (List<Topic>) topicRepository.findAll();
    }

    static Topic unwrapTopic(Optional<Topic> entity,Long id){
        if(entity.isPresent()) return entity.get();
        else throw new TopicNotFoundException(id);
    }
    
}
