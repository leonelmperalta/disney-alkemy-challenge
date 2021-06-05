package com.leonelm.mundodisney.util;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
