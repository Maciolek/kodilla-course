package com.kodilla.good.patterns.challenges.producers;

public class User {

    private String name;
    private String surname;
    private String userName;
    private String adress;
    private String email;

    public User(String name, String surname, String userName, String adress, String email) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.adress = adress;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUserName() {
        return userName;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }
}
