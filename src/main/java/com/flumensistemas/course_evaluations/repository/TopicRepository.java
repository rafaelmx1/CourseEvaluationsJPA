package com.flumensistemas.course_evaluations.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.flumensistemas.course_evaluations.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic,Long> {
    List<Topic> findByCourseId(Long courseId);
}
