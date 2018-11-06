package com.company.model;

public class Seller extends Person {

    public Seller(String firstname, String lastname, int age){
        super(firstname, lastname, age, Role.SELLER);
    }
}
