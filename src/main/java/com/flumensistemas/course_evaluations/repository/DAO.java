package com.flumensistemas.course_evaluations.repository;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> getList();
    void create();
    Optional<T> get(Long id);
    void update(T t,Long id);
    void delete(Long id);
    
}
