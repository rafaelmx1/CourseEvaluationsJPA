package com.flumensistemas.course_evaluations.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="GRADE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PARTICIPANT_ID","EVALUATION_ID"})
})
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GRADE_ID")
    private Long id;

    @NonNull
    @Column(name="SCORE", nullable = false)
    private Double score;
    
    @Column(name="GRADE_DATE")
    private LocalDate scoreDate;

    @ManyToOne(optional=false)
    @JoinColumn(name="participant_id",referencedColumnName = "PARTICIPANT_ID")
    private Participant participant;

    @ManyToOne(optional=false)
    @JoinColumn(name="evaluation_id",referencedColumnName = "EVALUATION_ID")
    private Evaluation evaluation;
    
}
