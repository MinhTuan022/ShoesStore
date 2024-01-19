package com.example.shoesstore.Security.Service;

import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Model.Requests.JwtAuthenticationResponse;
import com.example.shoesstore.Model.Requests.RefreshTokenRequest;
import com.example.shoesstore.Model.Requests.SignInRequest;
import com.example.shoesstore.Model.Requests.SignUpRequest;
//import com.example.shoesstore.Security.Service.Impl.UserDetailsImpl;


public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
