package com.flamingo.qa.api.tests;

import com.flamingo.qa.api.data.BookingProvider;
import com.flamingo.qa.api.data.UserProvider;
import com.flamingo.qa.api.helpers.AuthApi;
import com.flamingo.qa.api.helpers.BookingApi;
import com.flamingo.qa.api.helpers.RestAssuredSpecHelper;
import com.flamingo.qa.api.models.AuthToken;
import com.flamingo.qa.api.models.Booking;
import com.flamingo.qa.api.models.ExistingBooking;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
@DisplayName("Booking CRUD")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingCRUDTest extends BaseApiTest {

    private static BookingApi bookingApi;

    @BeforeAll
    public static void beforeAll() {
        AuthToken token = AuthApi.authorize(UserProvider.getUser());
        RequestSpecification authSpec = RestAssuredSpecHelper.authorizedSpec(token);
        bookingApi = new BookingApi(authSpec);
    }

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
