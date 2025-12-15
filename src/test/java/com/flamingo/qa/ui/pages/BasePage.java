package com.flamingo.qa.ui.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BasePage {

    public void screenshot() {
        this.screenshot("image.png");
    }

    public void screenshot(String name) {
        byte[] screen= Selenide.screenshot(OutputType.BYTES);
        if (screen == null) {
            Allure.attachment("Error taking screenshot", "null");
        } else {
            try (InputStream is = new ByteArrayInputStream(screen)) {
                Allure.attachment(name, is);
            } catch (IOException e) {
                Allure.attachment("Error taking screenshot", e.getMessage());
            }
        }
    }
}
