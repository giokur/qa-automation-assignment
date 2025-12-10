package com.flamingo.qa.api.helpers;

import com.flamingo.qa.api.models.Booking;
import com.flamingo.qa.api.models.ExistingBooking;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BookingApi {
    private final RequestSpecification spec;

    public BookingApi(RequestSpecification requestSpecification) {
        spec = requestSpecification;
    }

    public ExistingBooking createBooking(Booking booking) {
        return given(spec).body(booking).post("/booking").then().statusCode(200).extract().as(ExistingBooking.class);
    }

    public Booking getBooking(int id) {
        return  given(spec).get("/booking/{id}", id).then().statusCode(200).extract().as(Booking.class);
    }

    public Booking updateBooking(ExistingBooking booking) {
        return  given(spec).body(booking.getBooking()).put("/booking/{id}", booking.getBookingid()).then().statusCode(200).extract().as(Booking.class);
    }

    public Response deleteBooking(int id) {
        return given(spec).delete("/booking/{id}", id);
    }
}
