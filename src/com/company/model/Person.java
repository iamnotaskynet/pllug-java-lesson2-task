package com.company.model;

import com.company.model.Role;

public abstract class Person {

    //Constants for StringBuilder in overrided toString
    private static final String TAB_STR = "\t";
    private static final String ID_STR = "ID:";

    //Counting identifier must be unique, maybe should use some kind of Collection
    private static int idCounting = 0;

    private int uuId;
    private String firstname;
    private String lastname;
    private int age;
    private Role role;

    public Person(String firstname, String lastname, int age, Role role){
        ++idCounting;
        this.uuId = idCounting;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.role = role;
    }

    public int getUuId() {
        return this.uuId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TAB_STR);
        sb.append(ID_STR);
        sb.append(TAB_STR);
        sb.append(this.uuId);
        return sb.toString();
    }
    //    abstract String getFirstname();
    //    abstract String getLastname();
    //    abstract int getAge();

}
