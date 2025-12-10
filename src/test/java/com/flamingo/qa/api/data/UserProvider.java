package com.flamingo.qa.api.data;

import com.flamingo.qa.api.config.DefaultSettings;
import com.flamingo.qa.api.models.User;

public class UserProvider {
    public static User getUser() {
        return DefaultSettings.USER;
    }
}
