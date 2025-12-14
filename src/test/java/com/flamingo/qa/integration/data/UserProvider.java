package com.flamingo.qa.integration.data;


import com.flamingo.qa.integration.models.User;

public class UserProvider {
    public static User getUser() {
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");
        if  (username == null || password == null) {
            throw new RuntimeException("No USERNAME or PASSWORD env var is set");
        }
        return new User(username, password);
    }

}
