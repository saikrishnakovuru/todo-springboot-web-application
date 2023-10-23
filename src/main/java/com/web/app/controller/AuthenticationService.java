package com.web.app.controller;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isUserNamePasswordValid(String name, String password) {
        return name.equalsIgnoreCase("sai") && password.equalsIgnoreCase("sai");
    }
}
