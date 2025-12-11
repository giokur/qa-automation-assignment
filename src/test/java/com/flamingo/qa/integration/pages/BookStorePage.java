package com.flamingo.qa.integration.pages;

import com.flamingo.qa.integration.config.DefaultSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class BookStorePage {

    private static final By SEARCH = By.id("searchBox");
    private static final By BOOK = By.cssSelector("[role='row'] .mr-2 a");

    @Step
    public void search(String bookTitle) {
        open(DefaultSettings.UI_URL.concat("/books"));
        $(SEARCH).val(bookTitle);
        $$(BOOK).shouldHave(sizeGreaterThan(0));
    }

    @Step
    public boolean isBookListed(String bookTitle) {
        return $$(BOOK).texts().stream().anyMatch(t->t.equals(bookTitle));
    }
}
