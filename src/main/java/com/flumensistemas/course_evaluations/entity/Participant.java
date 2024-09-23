package com.flumensistemas.course_evaluations.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PARTICIPANT")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARTICIPANT_ID")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "NAME",nullable=false)
    @NonNull
    private String name;

    @NotBlank(message = "Last name cannot be blank")
    @Column(name = "LAST_NAME",nullable=false)
    @NonNull
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Column(name = "EMAIL",nullable=false)
    @NonNull
    private String email;
    
    @Column(name = "ENROLLMENT_DATE")
    private LocalDate enrollmentDate;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @NotBlank(message = "Status cannot be blank")
    @Column(name = "STATUS",nullable=false)
    @NonNull
    private String status;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnore
    private Set<Group> groups;

    @JsonIgnore
    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Grade> grades;
    
}
