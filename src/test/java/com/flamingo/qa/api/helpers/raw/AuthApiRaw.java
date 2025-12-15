package com.flamingo.qa.api.helpers.raw;

import com.flamingo.qa.api.helpers.RestAssuredSpecHelper;
import com.flamingo.qa.api.models.User;
import com.flamingo.qa.reporting.Reportable;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApiRaw implements Reportable {
    public Response authorize(User user) {
        return given(RestAssuredSpecHelper.unauthorizedSpec()).body(user).post("/auth");
    }
}
