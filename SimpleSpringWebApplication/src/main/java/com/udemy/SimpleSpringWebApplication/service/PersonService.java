package com.udemy.SimpleSpringWebApplication.service;

import com.udemy.SimpleSpringWebApplication.constants.EazySchoolConstants;
import com.udemy.SimpleSpringWebApplication.model.Roles;
import com.udemy.SimpleSpringWebApplication.model.Person;
import com.udemy.SimpleSpringWebApplication.repository.PersonRepository;
import com.udemy.SimpleSpringWebApplication.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
