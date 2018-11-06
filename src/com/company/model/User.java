package com.company.model;

public class User extends Person {


    public User(String firstname, String lastname, int age){
        super(firstname, lastname, age, Role.USER);
    }
}
