package com.flumensistemas.course_evaluations;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.flumensistemas.course_evaluations.controller.CourseController;

@SpringBootTest
@AutoConfigureMockMvc
class CourseEvaluationsApplicationTests {

	@Autowired
	private CourseController courseController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(courseController);
		assertNotNull(mockMvc);
	}

}
