package com.flumensistemas.course_evaluations.repository;

import com.flumensistemas.course_evaluations.entity.Staff;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StaffRepository implements DAO<Staff> {

private static final Logger LOGGER = LoggerFactory.getLogger(StaffRepository.class);

@Autowired
private JdbcTemplate queryUtils;

RowMapper<Staff> rowMapper = (rs,rowNum) -> {
    Staff staff = new Staff();
    staff.setId(rs.getLong("STAFF_ID"));
    staff.setName(rs.getString("NAME"));
    staff.setLastName(rs.getString("LAST_NAME"));
    staff.setEmail(rs.getString("EMAIL"));
    staff.setPassword("PASSWORD");
    staff.setRole(rs.getString("ROLE"));
    return staff;
};


@Override
public List<Staff> getList() {
    String sql = "SELECT STAFF_ID, NAME, LAST_NAME, EMAIL, ENROLLMENT_DATE, PASSWORD, ROLE, STATUS FROM STAFF";    
    return queryUtils.query(sql,rowMapper);
}

@Override
public void create() {
    // TODO Auto-generated method stub
    
}

@Override
public void delete(Long id) {
    // TODO Auto-generated method stub
    
}

@Override
public void update(Staff staff, Long id) {
    // TODO Auto-generated method stub
    
}

@Override
public Optional<Staff> get(Long id) {
    // TODO Auto-generated method stub
    return null;
}



} 
