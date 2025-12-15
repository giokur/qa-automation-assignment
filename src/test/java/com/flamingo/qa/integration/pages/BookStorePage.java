package com.flamingo.qa.integration.pages;

import com.flamingo.qa.integration.config.DefaultSettings;
import com.flamingo.qa.reporting.Reportable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class BookStorePage implements Reportable {

    private static final By SEARCH = By.id("searchBox");
    private static final By BOOK = By.cssSelector("[role='row'] .mr-2 a");

    public void search(String bookTitle) {
        open(DefaultSettings.UI_URL.concat("/books"));
        $(SEARCH).val(bookTitle);
        $$(BOOK).shouldHave(sizeGreaterThan(0));
    }

    public boolean isBookListed(String bookTitle) {
        return $$(BOOK).texts().stream().anyMatch(t->t.equals(bookTitle));
    }
}
