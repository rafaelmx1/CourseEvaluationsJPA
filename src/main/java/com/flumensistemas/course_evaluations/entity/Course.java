package com.flumensistemas.course_evaluations.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="COURSE")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COURSE_ID")
    private Long id;


    @NotBlank(message = "Course name cannot be blank")
    @NonNull
    @Column(name="COURSE_NAME", nullable = false, unique=true)
    private String courseName;

    @NotBlank(message = "Course status cannot be blank")
    @NonNull
    @Column(name="COURSE_STATUS",nullable = false)
    private String courseStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Group> groups;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Question> questions;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Topic> topics;


    
}
