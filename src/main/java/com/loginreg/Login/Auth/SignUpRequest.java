package com.loginreg.Login.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String fullName;

}
