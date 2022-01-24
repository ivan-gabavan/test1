package ru.kazemirov.webEmailApplication.service;

import org.jooq.DSLContext;
import ru.kazemirov.webEmailApplication.jooq.sample.model.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kazemirov.webEmailApplication.jooq.sample.model.tables.pojos.Email;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private DSLContext dsl;

    public List<Email> getEmails (){
            return dsl.selectFrom(Tables.EMAIL).fetchInto(Email.class);
    }

    public void insertEmail (Email email){
        dsl.insertInto(Tables.EMAIL).values(email.getId(), email.getEmail()).execute();
    }
}
