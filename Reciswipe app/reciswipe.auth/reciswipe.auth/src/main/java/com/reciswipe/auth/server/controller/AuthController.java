package com.reciswipe.auth.server.controller;


import com.reciswipe.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("auth")
@RestController
public class AuthController {


    @Autowired
    private AuthService authService;


    //TODO
    // create JWT Classes and config package for authorization of this service.

    //TODO
    // create signIn and signUp  on the platform.

    //TODO
    // create logOut on the platform.


}
