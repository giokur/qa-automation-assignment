package com.flamingo.qa.ui.data;

import com.flamingo.qa.ui.model.Gender;
import com.flamingo.qa.ui.model.Student;
import net.datafaker.Faker;

public class StudentProvider {
    public static Student getStudent() {
        Student student = new Student();
        Faker faker = new Faker();
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().lastName());
        student.setEmail(faker.internet().emailAddress());
        student.setGender(Gender.MALE);
        student.setUserNumber("1234567890");
        student.setDob(faker.timeAndDate().birthday(18, 22, "dd MMM yyyy"));
        student.setPicture("student.png");
        return student;
    }
}
