package com.flamingo.qa.api.models;

import lombok.Data;

@Data
public class AuthToken {
    private String token;
    private String reason;
}
