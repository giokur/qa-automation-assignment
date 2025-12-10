package com.flamingo.qa.api.helpers;

import com.flamingo.qa.api.models.AuthToken;
import com.flamingo.qa.api.models.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AuthApi {
    public static AuthToken authorize(User user) {
        return given(RestAssuredSpecHelper.unauthorizedSpec()).body(user).post("/auth").then().statusCode(200).extract().as(AuthToken.class);
    }
}
