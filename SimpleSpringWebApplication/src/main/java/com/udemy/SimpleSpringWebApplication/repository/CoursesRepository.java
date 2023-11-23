package com.udemy.SimpleSpringWebApplication.repository;

import com.udemy.SimpleSpringWebApplication.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}
