package com.flumensistemas.course_evaluations;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.flumensistemas.course_evaluations.repository.CourseRepository;
import com.flumensistemas.course_evaluations.service.CourseServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;
    
}
