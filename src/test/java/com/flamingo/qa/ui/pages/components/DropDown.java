package com.flamingo.qa.ui.pages.components;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class DropDown {
    private final By container;

    public DropDown(By container) {
        this.container = container;
    }

    public void select(String option) {
        $(container).scrollTo().click();
        ElementsCollection optionElements = $(container).$$("[class$='menu'] [class$='option']");
        List<String> options = optionElements.texts();
        optionElements.get(options.indexOf(option)).click();
    }
}
