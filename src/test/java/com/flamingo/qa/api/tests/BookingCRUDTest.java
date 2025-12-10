package com.flamingo.qa.api.tests;

import com.flamingo.qa.api.data.BookingProvider;
import com.flamingo.qa.api.models.Booking;
import com.flamingo.qa.api.models.ExistingBooking;
import com.flamingo.qa.api.tests.base.AuthorizedApiTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
@DisplayName("Booking CRUD")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingCRUDTest extends AuthorizedApiTest {

    @Test
    @Order(1)
    public void createBooking() {
        Booking booking = BookingProvider.getNewBooking();
        BookingProvider.setExistingBooking(bookingApi.createBooking(booking));
        assertThat(BookingProvider.getExistingBooking().getBookingid()).isGreaterThan(0);
        assertThat(BookingProvider.getExistingBooking().getBooking()).isEqualTo(booking);
    }

    @Test
    @Order(2)
    public void getBooking() {
        ExistingBooking existingBooking = BookingProvider.getExistingBooking();
        Booking booking = bookingApi.getBooking(existingBooking.getBookingid());
        assertThat(booking).isEqualTo(existingBooking.getBooking());
    }

    @Test
    @Order(3)
    public void updateBooking() {
        ExistingBooking existingBooking = BookingProvider.getUpdatedBooking();
        Booking booking = bookingApi.updateBooking(existingBooking);
        assertThat(booking).isEqualTo(existingBooking.getBooking());
    }

    @Test
    @Order(4)
    public void deleteBooking() {
        ExistingBooking existingBooking = BookingProvider.getExistingBooking();
        Response response = bookingApi.deleteBooking(existingBooking.getBookingid());
        assertThat(response.statusCode()).isEqualTo(201);
    }
}
