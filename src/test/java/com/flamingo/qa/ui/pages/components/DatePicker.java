package com.flamingo.qa.ui.pages.components;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DatePicker {
    private final By container;

    public DatePicker(By container) {
        this.container = container;
    }

    public void selectDate(String date) {
        String [] dates = date.split("\\s+");
        this.selectDate(dates[0], dates[1], dates[2]);
    }

    public void selectDate(String day, String month, String year) {
        $(container).$("input").click();
        $(container).$(".react-datepicker__year-select").selectOption(year);
        $(container).$(".react-datepicker__month-select").selectOption(month);
        $(container).$(".react-datepicker__day--0".concat(day)).click();
    }
}
