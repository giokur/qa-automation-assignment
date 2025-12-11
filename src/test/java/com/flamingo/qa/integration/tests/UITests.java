package com.flamingo.qa.integration.tests;

import com.flamingo.qa.integration.data.BookProvider;
import com.flamingo.qa.integration.data.UserProvider;
import com.flamingo.qa.integration.pages.BookStorePage;
import com.flamingo.qa.integration.pages.LoginPage;
import com.flamingo.qa.integration.tests.base.BaseUITest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
@DisplayName("Booking CRUD")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UITests extends BaseUITest {

    @BeforeAll
    public static void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs(UserProvider.getUser());
    }

    @Test
    public void searchTest() {
        BookStorePage bookStorePage = new BookStorePage();
        bookStorePage.search(BookProvider.getBookToSearch());
        assertThat(bookStorePage.isBookListed(BookProvider.getBookToSearch())).isTrue();
    }


}
