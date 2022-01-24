package ru.kazemirov.webEmailApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kazemirov.webEmailApplication.jooq.sample.model.tables.pojos.Email;
import ru.kazemirov.webEmailApplication.service.EmailService;

import java.util.ArrayList;

@RestController
public class EmailController {
    @Autowired
    private EmailService service;

    @PostMapping(value = "/add-email")
    public String addEmail(@RequestBody Email email) {
        service.insertEmail(email);
        return  String.format(email + " is added!");
    }
    @GetMapping("/users-list")
    public ArrayList<String> getEmailWithStr(@RequestParam(value = "q") String email_fragment) {
        ArrayList<String> emails = new ArrayList<String>();
        for (Email email: service.getEmails()) {
            if (email.getEmail().contains(email_fragment)){
                emails.add(email.getEmail());
            }
        }
        return emails;
    }

}
