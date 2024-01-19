package com.example.shoesstore.Model.Requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private String refreshToken;
}
