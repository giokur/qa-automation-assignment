package com.flamingo.qa.ui.model;

import lombok.Data;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String userNumber;
    private String dob;
    private String subject;
    private String picture;
    private String state;
    private String city;
}
