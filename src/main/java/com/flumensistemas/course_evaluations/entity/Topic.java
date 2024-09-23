package com.flumensistemas.course_evaluations.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TOPIC")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOPIC_ID")
    private Long id;

    @NotBlank(message = "Topic name cannot be blank")
    @NonNull
    @Column(name = "TOPIC_NAME")
    private String topicName;
    
    @Column(name = "TOPIC_DESCRIPTION")
    private String topicDescription;

    @ManyToOne(optional=false)
    @JoinColumn(name="course_id",referencedColumnName = "COURSE_ID")
    private Course course;

    @JsonIgnore
    @OneToMany(mappedBy = "topic")
    private List<Question> questions;

    @JsonIgnore
    @OneToMany(mappedBy = "topic")
    private List<Evaluation> evaluations;
    
}
