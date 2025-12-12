package com.flamingo.qa.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.flamingo.qa.ui.model.Gender;
import com.flamingo.qa.ui.model.Student;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FinalForm {

    private static final By MODAL = By.id("example-modal-sizes-title-lg");

    @Step
    public Student getStudent() {
        $(MODAL).shouldBe(visible);
        Student student = new Student();
        ElementsCollection cells = $$("td");
        String[] fullName = cells.get(1).getText().split("\\s+");
        student.setFirstName(fullName[0]);
        student.setLastName(fullName[1]);
        student.setEmail(cells.get(3).getText());
        switch (cells.get(5).getText()) {
            case "Male":
                student.setGender(Gender.MALE);
                break;
            case "Female":
                student.setGender(Gender.FEMALE);
                break;
            default:
                student.setGender(Gender.OTHER);
        }
        student.setUserNumber(cells.get(7).getText());
        student.setDob(cells.get(9).getText().replace(',', ' '));
        student.setSubject(cells.get(11).getText());
        student.setPicture(cells.get(15).getText());
        String[] stateCity = cells.get(19).getText().split("\\s+");
        student.setState(stateCity[0]);
        student.setCity(stateCity[1]);
        return student;
    }
}
