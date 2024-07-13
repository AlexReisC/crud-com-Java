package com.agenda.aplication;

import java.util.Date;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contact;

public class Main {
    public static void main(String[] args) {
        ContactDAO contactDAO = new ContactDAO();

        Contact contact1 = new Contact();
        contact1.setName("Alex Reis");
        contact1.setAge(22);
        contact1.setDateRegister(new Date());

        contactDAO.save(contact1);
    }
}
