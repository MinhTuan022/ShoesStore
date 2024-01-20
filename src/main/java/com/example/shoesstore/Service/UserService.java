package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

//import com.example.shoesstore.Entity.User;
//import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
//import com.example.shoesstore.Model.Requests.CreateUserRequest;
//import com.example.shoesstore.Model.Requests.LoginRequest;
//import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
//
//import java.util.List;
//
public interface UserService {
    UserDetailsService userDetailsService();
//    List<User> getAllCustomer();
//
    User getUser(String username);
//
////    boolean loginCustomer(LoginRequest request);
//
//    User loginCustomer(LoginRequest request);
//    User createCustomer(CreateUserRequest request);
//
//    User updateCustomer(UpdateProfileRequest request);
//
//    void changePassword(ChangePasswordReqest passwordReqest);
}
