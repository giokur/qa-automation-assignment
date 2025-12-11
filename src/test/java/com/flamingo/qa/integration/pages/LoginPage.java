package com.flamingo.qa.integration.pages;

import com.flamingo.qa.integration.config.DefaultSettings;
import com.flamingo.qa.integration.models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    private static final By USERNAME = By.id("userName");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN = By.id("login");
    private static final By LOGOUT = By.id("submit");

    public void loginAs(User user) {
        open(DefaultSettings.UI_URL.concat("/login"));
        $(USERNAME).val(user.getUsername());
        $(PASSWORD).val(user.getPassword());
        $(LOGIN).click();
        $(LOGOUT).shouldBe(visible);
    }

    public boolean isLogoutDisplayed() {
        return $(LOGOUT).isDisplayed();
    }
}
