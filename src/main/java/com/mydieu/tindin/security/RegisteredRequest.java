package com.mydieu.tindin.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredRequest {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
}
