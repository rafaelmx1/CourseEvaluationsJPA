package com.flumensistemas.course_evaluations.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.flumensistemas.course_evaluations.entity.Evaluation;
import com.flumensistemas.course_evaluations.entity.Grade;
import com.flumensistemas.course_evaluations.entity.Participant;
import com.flumensistemas.course_evaluations.repository.GradeRepository;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeServiceImpl gradeService;

    @Test
    public void getAllGradesTest() {
        when(gradeRepository.findAll()).thenReturn(Arrays.asList(
            new Grade(1L, 9.2,LocalDate.now(), 
                new Participant(1L, "Rafael", "Lopez", "rafael@gmail.com", LocalDate.now(), "abc", "A", null, null), 
                new Evaluation(1L, "Evaluation - Description", LocalDate.now(), null, null, null)),
            new Grade(2L, 9.2,LocalDate.now(), 
                new Participant(1L, "Bruno", "Lopez", "bruno@gmail.com", LocalDate.now(), "abc", "A", null, null), 
                new Evaluation(1L, "Evaluation - Description", LocalDate.now(), null, null, null))
        ));

        List<Grade> result = gradeService.getAllGrades();

        assertEquals(9.2d, result.get(0).getScore());
        assertEquals(2L, result.get(1).getId());
    }



}
