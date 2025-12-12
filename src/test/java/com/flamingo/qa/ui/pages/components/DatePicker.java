package com.flamingo.qa.ui.pages.components;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DatePicker {
    private final String container;

    public DatePicker(String container) {
        this.container = container;
    }

    public void selectDate(String date) {
        String [] dates = date.split("\\s+");
        this.selectDate(dates[0], dates[1], dates[2]);
    }

    public void selectDate(String day, String month, String year) {
        $(container).$("input").click();
        selectOption(".react-datepicker__year-select", year);
        selectOption(".react-datepicker__month-select", month);
        $(container.concat(" ").concat(".react-datepicker__day--0").concat(day)).click();
    }

    private void selectOption(String css, String value) {
        WebElement element = executeJavaScript("return document.querySelector(arguments[0].concat(' ').concat(arguments[1]))", container, css);
        $(element).selectOption(value);
    }
}
