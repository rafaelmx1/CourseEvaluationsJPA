package com.flumensistemas.course_evaluations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flumensistemas.course_evaluations.entity.Course;
import com.flumensistemas.course_evaluations.entity.Evaluation;
import com.flumensistemas.course_evaluations.entity.Participant;
import com.flumensistemas.course_evaluations.entity.Topic;
import com.flumensistemas.course_evaluations.repository.CourseRepository;
import com.flumensistemas.course_evaluations.repository.EvaluationRepository;
import com.flumensistemas.course_evaluations.repository.ParticipantRepository;
import com.flumensistemas.course_evaluations.repository.TopicRepository;

import java.time.LocalDate;

@SpringBootApplication
public class CourseEvaluationsApplication implements CommandLineRunner{
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ParticipantRepository participantRepository;
	@Autowired
	EvaluationRepository evaluationRepository;
	@Autowired
	TopicRepository topicRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseEvaluationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Course[] courses = new Course[] {
			new Course("APX","A"),
			new Course("CELLS","A"),
			new Course("ASO","A"),
			new Course("DESARROLLO SEGURO","A"),
		};
		for (Course course : courses) {
			courseRepository.save(course);
		}
		Participant[] participants = new Participant[] {
			new Participant("Teresa","Gonzalez","tere.g@axity.com","A"),
			new Participant("Sergio","Larreaga","sergio.l@axity.com","A"),
			new Participant("Abraham","Hernandez","abraham.h@axity.com","A"),
			new Participant("Miguel","Uribe","Miguel.u@axity.com","A"),
		};
		for (Participant participant: participants){
			participantRepository.save(participant);
		}
		Course course = new Course();
		course.setCourse_name("Curso 1");
		course.setCourse_status("A");
		course.setId(1L);
		Topic topic = new Topic();
		topic.setId(1L);
		topic.setTopicName("Nombre de Tema");
		topic.setCourse(course);
		topicRepository.save(topic);



		LocalDate specificDate = LocalDate.of(2023, 1, 1);
		Evaluation ev = new Evaluation();
		Evaluation ev2 = new Evaluation();
		ev.setEvaluation_description("Descripción 1");
		ev2.setEvaluation_description("Descripción 2");
		ev.setCreation_date(specificDate);
		ev2.setCreation_date(specificDate);
		ev.setTopic(topic);
		ev2.setTopic(topic);
		Evaluation[] evaluations = new Evaluation[2];
		evaluations[0] = ev;
		evaluations[1] = ev2;
		for (Evaluation evaluation : evaluations) {
			evaluationRepository.save(evaluation);
		}


	}

}
