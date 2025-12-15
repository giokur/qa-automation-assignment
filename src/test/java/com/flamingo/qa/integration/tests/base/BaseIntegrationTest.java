package com.flamingo.qa.integration.tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

public class BaseIntegrationTest {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll =
            new ScreenShooterExtension(true).to("target/allure-results");

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }
}
