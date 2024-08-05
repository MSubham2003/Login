package com.loginreg.Login.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;


    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signup(
            @RequestBody SignUpRequest request
    ){
        return  ResponseEntity.ok(service.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> signup(
            @RequestBody AuthenticationRequest request
    ){
        return  ResponseEntity.ok(service.authenticate(request));
    }

}
