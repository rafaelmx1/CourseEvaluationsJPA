package com.flumensistemas.course_evaluations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flumensistemas.course_evaluations.entity.Staff;
import com.flumensistemas.course_evaluations.service.StaffService;

import java.util.List;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RequestMapping("/staff")
@RestController
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/all")
    public ResponseEntity<List<Staff>> getAllStaff(){
        return new ResponseEntity<>(staffService.getAllStaff(),HttpStatus.OK);
    }
    
}
