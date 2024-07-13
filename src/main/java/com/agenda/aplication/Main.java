package com.agenda.aplication;

import java.util.Date;
import java.util.List;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contact;

public class Main {
    public static void main(String[] args) {
        ContactDAO contactDAO = new ContactDAO();

        Contact contact1 = new Contact();
        contact1.setName("Neymá Junio");
        contact1.setAge(32);
        contact1.setDateRegister(new Date());

        contactDAO.save(contact1);

        List<Contact> list = contactDAO.getContacts();
        for (Contact c : list) {
            System.out.println("Contact: " + c.getName());
        }
    }
}
