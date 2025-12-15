package com.flamingo.qa.api.helpers.raw;

import com.flamingo.qa.api.models.Booking;
import com.flamingo.qa.api.models.ExistingBooking;
import com.flamingo.qa.reporting.Reportable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BookingApiRaw implements Reportable  {
    private final RequestSpecification spec;

    public BookingApiRaw(RequestSpecification requestSpecification) {
        spec = requestSpecification;
    }

    public Response createBooking(Booking booking) {
        return given(spec).body(booking).post("/booking");
    }

    public Response getBooking(int id) {
        return  given(spec).get("/booking/{id}", id);
    }

    public Response updateBooking(ExistingBooking booking) {
        return  given(spec).body(booking.getBooking()).put("/booking/{id}", booking.getBookingid());
    }

    public Response deleteBooking(int id) {
        return given(spec).delete("/booking/{id}", id);
    }
}
