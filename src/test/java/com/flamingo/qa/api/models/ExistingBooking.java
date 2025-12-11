package com.flamingo.qa.api.models;

import lombok.Data;

@Data
public class ExistingBooking {
    private int bookingid;
    private Booking booking;
}
