package com.agenda.model;

import java.util.Date;

public class Contact {
    private int id;
    private String name;
    private int age;
    private Date dateRegister;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getDateRegister() {
        return dateRegister;
    }
    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }
    
    
}
