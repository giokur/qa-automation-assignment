package com.flamingo.qa.api.tests.base;

import com.flamingo.qa.api.data.UserProvider;
import com.flamingo.qa.api.helpers.AuthApi;
import com.flamingo.qa.api.helpers.BookingApi;
import com.flamingo.qa.api.helpers.RestAssuredSpecHelper;
import com.flamingo.qa.api.models.AuthToken;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class AuthorizedApiTest {

    protected static BookingApi bookingApi;

    @BeforeAll
    public static void beforeAll() {
        AuthApi authApi = new AuthApi();
        AuthToken token = authApi.authorize(UserProvider.getUser());
        RequestSpecification authSpec = RestAssuredSpecHelper.authorizedSpec(token);
        bookingApi = new BookingApi(authSpec);
    }

}
