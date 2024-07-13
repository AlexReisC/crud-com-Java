package com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            try {
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
