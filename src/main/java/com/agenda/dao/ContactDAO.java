package com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.agenda.factory.ConnectionFactory;
import com.agenda.model.Contact;

public class ContactDAO {
    public void save(Contact contact){
        String sql = "INSERT INTO contacts(name, age, dateRegister) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, new Date(contact.getDateRegister().getTime()));

            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Contact save sucessfully!");
            try {
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Contact> getContacts(){
        String sql = "SELECT * FROM contacts";

        List<Contact> contacts = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Contact contact = new Contact();
                contact.setId(rset.getInt("id"));
                contact.setName(rset.getString("name"));
                contact.setAge(rset.getInt("age"));
                contact.setDateRegister(rset.getDate("dateRegister"));
                contacts.add(contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return contacts;
    }

    public void update(Contact contact){
        String sql = "UPDATE contacts SET name = ?, age = ?, dateRegister = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contact.getName());
            pstm.setInt(2, contact.getAge());
            pstm.setDate(3, new Date(contact.getDateRegister().getTime()));
            pstm.setInt(4,contact.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
