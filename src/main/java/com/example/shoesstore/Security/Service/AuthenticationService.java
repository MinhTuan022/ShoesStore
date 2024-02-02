package com.example.shoesstore.Security.Service;

import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Model.Requests.*;
//import com.example.shoesstore.Security.Service.Impl.UserDetailsImpl;


public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    void changePassword(String email, ChangePasswordRequest passwordRequest);
}
