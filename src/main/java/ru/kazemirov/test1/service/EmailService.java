package ru.kazemirov.test1.service;

import org.jooq.DSLContext;
import ru.kazemirov.test1.jooq.sample.model.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kazemirov.test1.jooq.sample.model.tables.pojos.Email;

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
