package com.flamingo.qa.api.data;

import com.flamingo.qa.api.models.Booking;
import com.flamingo.qa.api.models.BookingDates;
import com.flamingo.qa.api.models.ExistingBooking;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;

import java.util.concurrent.TimeUnit;

public class BookingProvider {
    private static final Faker faker = new Faker();

    @Setter @Getter private static ExistingBooking existingBooking;

    public static Booking getNewBooking() {
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.number().numberBetween(100, 200));
        booking.setDepositpaid(true);
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(faker.timeAndDate().future(7, TimeUnit.DAYS, "yyyy-MM-dd"));
        bookingDates.setCheckout(faker.timeAndDate().future(14, TimeUnit.DAYS, "yyyy-MM-dd"));
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        return  booking;
    }

    public static ExistingBooking getUpdatedBooking() {
        BookingDates bookingDates = existingBooking.getBooking().getBookingdates();
        bookingDates.setCheckin(faker.timeAndDate().future(9, TimeUnit.DAYS, "yyyy-MM-dd"));
        bookingDates.setCheckout(faker.timeAndDate().future(16, TimeUnit.DAYS, "yyyy-MM-dd"));
        existingBooking.getBooking().setAdditionalneeds("Transfer");
        return existingBooking;
    }

    public static ExistingBooking getNotExistingBooking() {
        ExistingBooking booking = new ExistingBooking();
        booking.setBooking(getNewBooking());
        booking.setBookingid(faker.number().numberBetween(1000, 2000));
        return  booking;
    }

}
