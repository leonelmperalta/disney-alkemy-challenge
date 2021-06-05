package com.leonelm.mundodisney.util;

public class AuthenticationResponse {

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    private final String jwt;
    public String getJwt() {
        return jwt;
    }
}
