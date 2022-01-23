package ru.kazemirov.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kazemirov.test1.jooq.sample.model.tables.pojos.Email;
import ru.kazemirov.test1.service.EmailService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Test1Application {
    @Autowired
    private EmailService service;

    public static void main(String[] args) {

        SpringApplication.run(Test1Application.class, args);
    }
    @GetMapping("/add-email")
    public String addEmail(@RequestParam(value = "id") int id,@RequestParam(value = "email") String email) {
        service.insertEmail(new Email(id, email));
        return  String.format(email + " is added!");
    }
    @GetMapping("/users-list")
    public String getEmailWithStr(@RequestParam(value = "q") String email_fragment) {
        ArrayList<String> emails = new ArrayList<String>();
        for (Email email: service.getEmails()) {
            if (email.getEmail().contains(email_fragment)){
                emails.add(email.getEmail());
            }
        }
        return emails.toString();
    }

}
