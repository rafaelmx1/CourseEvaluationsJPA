package com.flumensistemas.course_evaluations.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.flumensistemas.course_evaluations.entity.Question;

import jakarta.transaction.Transactional;


public interface QuestionRepository extends CrudRepository<Question,Long> {
    List<Question> findByCourseIdAndTopicId(Long courseId,Long topicId);
    @Transactional
    void deleteByCourseIdAndTopicId(Long courseId,Long topicId);
    List<Question> findByCourseId(Long courseId);
}
