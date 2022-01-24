package ru.kazemirov.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kazemirov.test1.jooq.sample.model.tables.pojos.Email;
import ru.kazemirov.test1.service.EmailService;

import java.util.ArrayList;

@RestController
public class EmailController {
    @Autowired
    private EmailService service;

    @GetMapping("/add-email")
    public String addEmail(@RequestParam(value = "id") int id, @RequestParam(value = "email") String email) {
        service.insertEmail(new Email(id, email));
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
