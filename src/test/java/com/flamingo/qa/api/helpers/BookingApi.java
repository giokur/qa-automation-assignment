package com.flamingo.qa.api.helpers;

import com.flamingo.qa.api.helpers.raw.BookingApiRaw;
import com.flamingo.qa.api.models.Booking;
import com.flamingo.qa.api.models.ExistingBooking;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingApi {
    private final BookingApiRaw bookingApiRaw;

    public BookingApi(RequestSpecification requestSpecification) {
        bookingApiRaw = new BookingApiRaw(requestSpecification);
    }

    public ExistingBooking createBooking(Booking booking) {
        return ResponseParser.parse(bookingApiRaw.createBooking(booking), ExistingBooking.class);
    }

    public Booking getBooking(int id) {
        return ResponseParser.parse(bookingApiRaw.getBooking(id), Booking.class);
    }

    public Booking updateBooking(ExistingBooking booking) {
        return ResponseParser.parse(bookingApiRaw.updateBooking(booking), Booking.class);
    }

    public Response deleteBooking(int id) {
        return bookingApiRaw.deleteBooking(id);
    }
}
