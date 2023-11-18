package com.udemy.SimpleSpringWebApplication.controller;

import com.udemy.SimpleSpringWebApplication.model.Contact;
import com.udemy.SimpleSpringWebApplication.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

    @Slf4j
    @Controller
    public class ContactController {

        private final ContactService contactService;

        private static Logger log = LoggerFactory.getLogger(ContactController.class);

        @Autowired
        public ContactController(ContactService contactService) {
            this.contactService = contactService;
        }

        @RequestMapping("/contact")
        public String displayContactPage() {
            return "contact.html";
        }

//    @RequestMapping(value = "/saveMsg",method = POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//        log.info("Name : " + name);
//        log.info("Mobile Number : " + mobileNum);
//        log.info("Email Address : " + email);
//        log.info("Subject : " + subject);
//        log.info("Message : " + message);
//        return new ModelAndView("redirect:/contact");
//    }

        @RequestMapping(value = "/saveMsg",method = POST)
        public ModelAndView saveMessage(Contact contact){
            contactService.saveMessageDetails(contact);
            return new ModelAndView("redirect:/contact");
        }

    }
