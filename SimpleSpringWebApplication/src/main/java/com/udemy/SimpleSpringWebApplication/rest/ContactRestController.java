package com.udemy.SimpleSpringWebApplication.rest;

import com.udemy.SimpleSpringWebApplication.model.Contact;
import com.udemy.SimpleSpringWebApplication.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/contact")
public class ContactRestController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/getMessagesByStatus")
    public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status){
        return contactRepository.findByStatus(status);
    }

    @GetMapping("/getAllMsgsByStatus")
    public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact){
        if(null != contact && null != contact.getStatus()){
            return contactRepository.findByStatus(contact.getStatus());
        }else {
            return List.of();
        }
    }
}
