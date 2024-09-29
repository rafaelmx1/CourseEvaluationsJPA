package com.flumensistemas.course_evaluations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flumensistemas.course_evaluations.entity.Staff;
import com.flumensistemas.course_evaluations.repository.StaffRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;
    
    @Override
    public List<Staff> getAllStaff() {
        return (List<Staff>) staffRepository.getList();
    }

}
