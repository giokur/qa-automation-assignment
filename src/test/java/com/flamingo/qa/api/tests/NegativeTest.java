package com.flamingo.qa.api.tests;

import com.flamingo.qa.api.data.BookingProvider;
import com.flamingo.qa.api.data.UserProvider;
import com.flamingo.qa.api.models.AuthToken;
import com.flamingo.qa.api.tests.base.UnauthorizedApiTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
@DisplayName("Booking Negative tests")
public class NegativeTest extends UnauthorizedApiTest {

    @Test
    public void invalidAuthentication() {
        AuthToken authToken = authApi.authorize(UserProvider.getInvalidUser());
        assertThat(authToken.getReason()).isEqualTo("Bad credentials");
    }

    @Test
    public void unauthorizedBookingUpdate() {
        Response response = bookingApi.updateBooking(BookingProvider.getNotExistingBooking());
        assertThat(response.statusCode()).isEqualTo(403);
    }

    @Test
    public void getNotExistingBooking() {
        Response response = bookingApi.getBooking(0);
        assertThat(response.statusCode()).isEqualTo(404);
    }

}
