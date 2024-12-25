package com.otsoi.playtests.entities;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder(toBuilder = true)
public class TestUser {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String ssn;

    @Override
    public String toString() {
        return "TestUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
