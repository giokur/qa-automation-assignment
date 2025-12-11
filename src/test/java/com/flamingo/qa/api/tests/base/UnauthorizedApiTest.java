package com.flamingo.qa.api.tests.base;

import com.flamingo.qa.api.helpers.AuthApi;
import com.flamingo.qa.api.helpers.raw.BookingApiRaw;
import com.flamingo.qa.api.helpers.RestAssuredSpecHelper;
import org.junit.jupiter.api.BeforeAll;

public abstract class UnauthorizedApiTest {

    protected static BookingApiRaw bookingApi;
    protected static AuthApi authApi;

    @BeforeAll
    public static void beforeAll() {
        bookingApi = new BookingApiRaw(RestAssuredSpecHelper.unauthorizedSpec());
        authApi = new AuthApi();
    }

}
