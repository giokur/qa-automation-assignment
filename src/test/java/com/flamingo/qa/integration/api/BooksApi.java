package com.flamingo.qa.integration.api;

import com.flamingo.qa.integration.models.BookList;

import static io.restassured.RestAssured.given;

public class BooksApi {
    public static BookList getBooks() {
        return given().get("https://demoqa.com/BookStore/v1/Books").then().statusCode(200).extract().body().as(BookList.class);
    }
}
