package com.flamingo.qa.api.helpers;

import com.flamingo.qa.api.helpers.raw.AuthApiRaw;
import com.flamingo.qa.api.models.AuthToken;
import com.flamingo.qa.api.models.User;

public class AuthApi {
    private final AuthApiRaw authApiRaw;

    public AuthApi() {
        authApiRaw = new AuthApiRaw();
    }

    public AuthToken authorize(User user) {
        return ResponseParser.parse(authApiRaw.authorize(user), AuthToken.class);
    }
}
