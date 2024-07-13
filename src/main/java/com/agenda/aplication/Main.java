package com.agenda.aplication;

import java.util.Date;
import java.util.List;

import com.agenda.dao.ContactDAO;
import com.agenda.model.Contact;

public class Main {
    public static void main(String[] args) {
        ContactDAO contactDAO = new ContactDAO();

        Contact contact1 = new Contact();
        contact1.setName("João");
        contact1.setAge(15);
        contact1.setDateRegister(new Date());

        //contactDAO.save(contact1);

        Contact contact2 = new Contact();
        contact2.setName("Francisco");
        contact2.setAge(55);
        contact2.setDateRegister(new Date());
        contact2.setId(3);

        // contactDAO.update(contact2);

        contactDAO.deleteById(1);

        List<Contact> list = contactDAO.getContacts();
        for (Contact c : list) {
            System.out.println("Contact: " + c.getName());
        }
    }
}
