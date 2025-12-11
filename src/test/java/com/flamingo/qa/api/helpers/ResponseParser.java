package com.flamingo.qa.api.helpers;

import io.restassured.response.Response;

public class ResponseParser {
    public static <T> T parse(Response response, Class<T> clas) {
        return parse(response, clas, 200);
    }
    public static <T> T parse(Response response, Class<T> clas, int statusCode) {
        return response.then().statusCode(statusCode).extract().body().as(clas);
    }
}
