package com.example.upgrad.clientapp.Resources;

import lombok.Builder;

@Builder
public class userObject {

    private String firstname;
    private String lastname;
    private int age;
    private Boolean single;

    public userObject(String firstname, String lastname, int age, Boolean single) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.single = single;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getSingle() {
        return single;
    }

    public void setSingle(Boolean single) {
        this.single = single;
    }

    @Override
    public String toString() {
        return "userObject{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", single=" + single +
                '}';
    }

    public userObject() {
    }
}
