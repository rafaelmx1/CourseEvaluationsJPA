package com.flumensistemas.course_evaluations.entity;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate enrollmentDate;
    private String password;
    private String role;

}
