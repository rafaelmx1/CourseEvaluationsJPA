package com.flumensistemas.course_evaluations.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name="EVALUATION")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EVALUATION_ID")
    private Long id;

    @NotBlank(message = "Evaluation description cannot be blank")
    @NonNull
    @Column(name="EVALUATION_DESCRIPTION", nullable = false, unique=true)
    private String evaluation_description;

    @NonNull
    @Column(name="CREATION_DATE")
    private LocalDate creation_date;

    @ManyToOne(optional = false)
    @JoinColumn(name="topic_id",referencedColumnName = "TOPIC_ID")
    private Topic topic;

    @JsonIgnore
    @OneToMany(mappedBy = "evaluation",cascade = CascadeType.ALL)
    private List<Grade> grades;

}
