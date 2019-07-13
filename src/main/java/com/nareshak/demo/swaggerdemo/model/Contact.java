package com.nareshak.demo.swaggerdemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Contact implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(Long id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
