package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Model.Requests.ChangePasswordRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService {
    UserDetailsService userDetailsService();
    List<User> getAllUser();
    User getUser(String username);

    User updateUser(String email, UpdateProfileRequest request);

//    void changePassword(String email, ChangePasswordRequest passwordRequest);
}
