package com.flamingo.qa.integration.tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

public class BaseUITest {

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }
}
