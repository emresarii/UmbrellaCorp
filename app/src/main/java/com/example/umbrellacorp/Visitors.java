package com.example.umbrellacorp;

import java.io.Serializable;

public class Visitors implements Serializable {
    public String name;
    public String email;
    public String phone;
    public String message;

    public Visitors(String name, String email, String phone, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }
    public Visitors(){

    }

}
