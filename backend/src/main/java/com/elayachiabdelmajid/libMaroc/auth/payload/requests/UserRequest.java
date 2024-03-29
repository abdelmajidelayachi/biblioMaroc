package com.elayachiabdelmajid.libMaroc.auth.payload.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String confirmPassword;
    private String username;
    private String phone;
}
