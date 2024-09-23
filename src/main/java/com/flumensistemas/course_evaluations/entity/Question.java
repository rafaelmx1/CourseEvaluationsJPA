package com.flumensistemas.course_evaluations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long id;

    @Column(name = "GIF_ID",nullable=true)
    private String gifId;

    @NonNull
    @Column(name = "NUMBER_OF_ANSWERS",nullable=false)
    private Integer numberOfAnswers;

    @NonNull
    @Column(name = "RADIO_OR_CHECK",nullable=false)
    private Character radioOrCheck;

    @NotBlank(message = "Statement cannot be blank")
    @Column(name = "STATEMENT",nullable=false)
    @NonNull
    private String statement;

    @NotBlank(message = "Answer 1 cannot be blank")
    @Column(name = "ANSWER_1",nullable=false)
    @NonNull
    private String answer1;
    
    @NotBlank(message = "Answer 2 cannot be blank")
    @Column(name = "ANSWER_2",nullable=false)
    @NonNull
    private String answer2;
    @Column(name = "ANSWER_3")
    
    private String answer3;
    @Column(name = "ANSWER_4")
    private String answer4;
    @Column(name = "ANSWER_5")
    private String answer5;
    @Column(name = "ANSWER_6")
    private String answer6;
    @Column(name = "ANSWER_7")
    private String answer7;
    @Column(name = "ANSWER_8")
    private String answer8;
    @Column(name = "ANSWER_9")
    private String answer9;
    @Column(name = "ANSWER_10")
    private String answer10;
    @Column(name = "STATUS")
    private String status;

    @ManyToOne(optional = false)
    @JoinColumn(name="course_id",referencedColumnName = "COURSE_ID")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name="topic_id",referencedColumnName = "TOPIC_ID")
    private Topic topic;


    
}
