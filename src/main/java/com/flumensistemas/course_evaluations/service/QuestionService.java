package com.flumensistemas.course_evaluations.service;

import java.util.List;

import com.flumensistemas.course_evaluations.entity.Question;

public interface QuestionService {

    Question saveQuestion(Question question,Long courseId,Long topicId);
    void deleteQuestion(Long id);
    void deleteQuestionByCourseIdAndTopicId(Long courseId,Long topicId);
    Question getQuestion(Long id);
    List<Question> getQuestions();
    List<Question> getQuestionsByCourseIdAndTopicId(Long courseId,Long topicId);
    List<Question> getQuestionsByCourseId(Long courseId);
    
}
