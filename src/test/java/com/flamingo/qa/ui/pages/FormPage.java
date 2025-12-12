package com.flamingo.qa.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.flamingo.qa.ui.config.DefaultSettings;
import com.flamingo.qa.ui.model.Gender;
import com.flamingo.qa.ui.model.Student;
import com.flamingo.qa.ui.pages.components.DatePicker;
import com.flamingo.qa.ui.pages.components.DropDown;
import com.flamingo.qa.ui.pages.components.MultiOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class FormPage {
    private static final By FIRST_NAME = By.id("firstName");
    private static final By LAST_NAME = By.id("lastName");
    private static final By EMAIL = By.id("userEmail");
    private static final By GENDER = By.name("gender");
    private static final By MOBILE = By.id("userNumber");
    private static final String DOB = "#dateOfBirth";
    private static final By SUBJECTS = By.id("subjectsContainer");
    private static final By PICTURE = By.id("uploadPicture");
    private static final By STATE = By.id("state");
    private static final By CITY = By.id("city");
    private static final By SUBMIT = By.id("submit");

    private final DatePicker dob;
    private final MultiOption subjects;
    private final DropDown state;
    private final DropDown city;

    public FormPage() {
        this.dob = new DatePicker(DOB);
        this.subjects = new MultiOption(SUBJECTS);
        this.state = new DropDown(STATE);
        this.city = new DropDown(CITY);
    }

    @Step
    public FormPage enterFirstName(String name) {
        $(FIRST_NAME).val(name);
        return this;
    }

    @Step
    public FormPage enterLastName(String name) {
        $(LAST_NAME).val(name);
        return this;
    }

    @Step
    public FormPage enterEmail(String email) {
        $(EMAIL).val(email);
        return this;
    }

    @Step
    public FormPage selectGender(Gender gender) {
        WebElement radio;
        switch (gender) {
            case Gender.MALE:
                radio  = $$(GENDER).get(0);
                break;
            case Gender.FEMALE:
                radio  = $$(GENDER).get(1);
                break;
            default:
                radio  = $$(GENDER).get(2);
        }
        executeJavaScript("arguments[0].click();", radio);
        return this;
    }

    @Step
    public FormPage enterMobile(String mobile) {
        $(MOBILE).val(mobile);
        return this;
    }

    @Step
    public FormPage enterDOB(String dob) {
        this.dob.selectDate(dob);
        return this;
    }

    public FormPage selectSubject(String subject) {
        this.subjects.select(subject);
        return this;
    }

    @Step
    public FormPage uploadPicture(String picture) {
        File uploadFile = new File("src/test/resources/".concat(picture));
        $(PICTURE).uploadFile(uploadFile);
        return this;
    }

    @Step
    public FormPage selectState(String state) {
        this.state.select(state);
        return this;
    }

    @Step
    public FormPage selectCity(String city) {
        this.city.select(city);
        return this;
    }

    @Step
    public void fillForm(Student student) {
        open(DefaultSettings.FORM_URL);
        this
            .enterFirstName(student.getFirstName())
            .enterLastName(student.getLastName())
            .enterEmail(student.getEmail())
            .selectGender(student.getGender())
            .enterMobile(student.getUserNumber())
            .enterDOB(student.getDob())
            .selectSubject(student.getSubject())
            .uploadPicture(student.getPicture())
            .selectState(student.getState())
            .selectCity(student.getCity())
        ;
    }

    @Step
    public void submit() {
        $(SUBMIT).scrollTo().click();
    }
}
