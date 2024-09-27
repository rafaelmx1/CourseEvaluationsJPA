package com.flumensistemas.course_evaluations.entity;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="GROUP_")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GROUP_ID")
    private Long group_id;

    @NotBlank(message = "Group name cannot be blank")
    @NonNull
    @Column(name="GROUP_NAME",nullable=false)
    private String groupName;


    @Column(name="START_DATE")
    private LocalDate startDate;
    @Column(name="END_DATE")
    private LocalDate endDate;

    @NotBlank(message = "Status name cannot be blank")
    @NonNull
    @Column(name="STATUS")
    private String status;

    @ManyToOne(optional=false)
    @JoinColumn(name="course_id",referencedColumnName = "COURSE_ID")
    private Course course;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "GROUP_ENROLLMENT",
        joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID"),
        inverseJoinColumns = @JoinColumn(name ="PARTICIPANT_ID",referencedColumnName="PARTICIPANT_ID")
    )
    private Set<Participant> participants;
}
