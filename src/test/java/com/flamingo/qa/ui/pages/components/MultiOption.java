package com.flamingo.qa.ui.pages.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MultiOption {

    private final By container;

    public MultiOption(By container) {
        this.container = container;
    }

    public void select(String option) {
        $(container).scrollTo().$("input").val(option);
        $(container).$(".subjects-auto-complete__option").click();
    }
}
