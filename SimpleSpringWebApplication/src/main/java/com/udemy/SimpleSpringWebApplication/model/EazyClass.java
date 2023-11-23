package com.udemy.SimpleSpringWebApplication.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
@Table(name = "class")
public class EazyClass extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int classId;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, message = "Name cannot be smaller then 3")
    private String name;

    @OneToMany(mappedBy = "eazyClass", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Person.class)
    private Set<Person> persons;
}
