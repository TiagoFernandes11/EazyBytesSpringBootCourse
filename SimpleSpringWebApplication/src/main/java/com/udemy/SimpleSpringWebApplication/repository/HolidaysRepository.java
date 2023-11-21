package com.udemy.SimpleSpringWebApplication.repository;

import com.udemy.SimpleSpringWebApplication.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {
}
