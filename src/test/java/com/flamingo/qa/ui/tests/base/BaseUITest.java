package com.flamingo.qa.ui.tests.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseUITest {
    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

}
