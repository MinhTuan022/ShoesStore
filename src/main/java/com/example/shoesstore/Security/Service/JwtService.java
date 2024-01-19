package com.example.shoesstore.Security.Service;

import com.example.shoesstore.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JwtService {
    boolean isTokenValid(String token, UserDetails userDetails);
    String generateToken(UserDetails userDetails);
    String extractUserName(String token);

    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
