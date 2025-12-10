package com.flamingo.qa.api.config;

import com.flamingo.qa.api.models.User;

public class DefaultSettings {
    public static String BOOKING_BASE_URL = "https://restful-booker.herokuapp.com";
    public static User USER = new User("admin", "password123");
}
