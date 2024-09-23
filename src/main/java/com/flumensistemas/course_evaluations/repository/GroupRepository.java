package com.flumensistemas.course_evaluations.repository;

import org.springframework.data.repository.CrudRepository;

import com.flumensistemas.course_evaluations.entity.Group;
import java.util.List;

public interface GroupRepository extends CrudRepository<Group,Long> {
    List<Group> findByCourseId(Long courseId);
}
