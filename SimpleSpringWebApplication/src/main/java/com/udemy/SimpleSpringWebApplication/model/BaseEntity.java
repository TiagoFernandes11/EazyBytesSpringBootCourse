package com.udemy.SimpleSpringWebApplication.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
    private LocalDateTime createdAt;
    private String updatedBy;
}
