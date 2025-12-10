package com.flamingo.qa.api.helpers;

import com.flamingo.qa.api.config.DefaultSettings;
import com.flamingo.qa.api.models.AuthToken;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;

public class RestAssuredSpecHelper {

    public static RequestSpecification unauthorizedSpec() {
        return specBuilder().build();
    }

    public static RequestSpecification authorizedSpec(AuthToken authToken) {
        Cookie cookie = new Cookie.Builder("token", authToken.getToken()).build();
        return specBuilder()
                .setAccept("application/json")
                .addCookie(cookie)
                .build();
    }

    private static RequestSpecBuilder specBuilder() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return new RequestSpecBuilder()
                .setBaseUri(getBaseUri())
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured());
    }

    private static String getBaseUri() {
        String baseUri = System.getenv("BOOKING_BASE_URL");
        if (baseUri == null) {
            baseUri = DefaultSettings.BOOKING_BASE_URL;
        }
        return baseUri;
    }
}
