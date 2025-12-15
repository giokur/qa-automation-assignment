package com.flamingo.qa.ui.pages;

import com.flamingo.qa.base.BasePage;
import com.flamingo.qa.reporting.Reportable;
import com.flamingo.qa.ui.config.DefaultSettings;
import com.flamingo.qa.ui.model.Gender;
import com.flamingo.qa.ui.model.Student;
import com.flamingo.qa.ui.pages.components.DatePicker;
import com.flamingo.qa.ui.pages.components.DropDown;
import com.flamingo.qa.ui.pages.components.MultiOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class FormPage extends BasePage implements Reportable {
    private static final By FIRST_NAME = By.id("firstName");
    private static final By LAST_NAME = By.id("lastName");
    private static final By EMAIL = By.id("userEmail");
    private static final By GENDER = By.name("gender");
    private static final By MOBILE = By.id("userNumber");
    private static final By DOB = By.id("dateOfBirth");
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

    public FormPage enterFirstName(String name) {
        $(FIRST_NAME).val(name);
        return this;
    }

    public FormPage enterLastName(String name) {
        $(LAST_NAME).val(name);
        return this;
    }

    public FormPage enterEmail(String email) {
        $(EMAIL).val(email);
        return this;
    }

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

    public FormPage enterMobile(String mobile) {
        $(MOBILE).val(mobile);
        return this;
    }

    public FormPage enterDOB(String dob) {
        this.dob.selectDate(dob);
        return this;
    }

    public FormPage selectSubject(String subject) {
        this.subjects.select(subject);
        return this;
    }

    public FormPage uploadPicture(String picture) {
        File uploadFile = new File("src/test/resources/".concat(picture));
        $(PICTURE).uploadFile(uploadFile);
        return this;
    }

    public FormPage selectState(String state) {
        this.state.select(state);
        return this;
    }

    public FormPage selectCity(String city) {
        this.city.select(city);
        return this;
    }

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
        this.screenshot("Form before submit");
    }

    public void submit() {
        $(SUBMIT).scrollTo().click();
    }
}
