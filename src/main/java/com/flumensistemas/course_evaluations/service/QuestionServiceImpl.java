package com.flumensistemas.course_evaluations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Course;
import com.flumensistemas.course_evaluations.entity.Question;
import com.flumensistemas.course_evaluations.entity.Topic;
import com.flumensistemas.course_evaluations.exception.QuestionNotFoundException;
import com.flumensistemas.course_evaluations.repository.CourseRepository;
import com.flumensistemas.course_evaluations.repository.QuestionRepository;
import com.flumensistemas.course_evaluations.repository.TopicRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService{
    
    QuestionRepository questionRepository;
    CourseRepository courseRepository;
    TopicRepository topicRepository;

    @Override
    public Question saveQuestion(Question question, Long courseId, Long topicId){
        Course course = courseRepository.findById(courseId).get();
        Topic topic = topicRepository.findById(topicId).get();
        question.setCourse(course);
        question.setTopic(topic);
        return questionRepository.save(question);
    }
    
    @Override
    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }
    @Override
    public void deleteQuestionByCourseIdAndTopicId(Long courseId,Long topicId){
        questionRepository.deleteByCourseIdAndTopicId(courseId, topicId);
    }
    @Override
    public Question getQuestion(Long id){
        Optional<Question> question = questionRepository.findById(id);
        return unwrapQuestion(question, id);
    }
    @Override
    public List<Question> getQuestions(){
        return (List<Question>) questionRepository.findAll();
    } 
    @Override
    public List<Question> getQuestionsByCourseIdAndTopicId(Long courseId, Long topicId){
        return (List<Question>) questionRepository.findByCourseIdAndTopicId(courseId,topicId);
    } 
    @Override
    public List<Question> getQuestionsByCourseId(Long courseId){
        return (List<Question>) questionRepository.findByCourseId(courseId);
    } 
    static Question unwrapQuestion(Optional<Question> entity,Long id){
        if(entity.isPresent()) return entity.get();
        else throw new QuestionNotFoundException(id);
    }


}
