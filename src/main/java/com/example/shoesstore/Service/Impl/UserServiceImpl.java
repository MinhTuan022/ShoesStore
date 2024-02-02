package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Model.Requests.ChangePasswordRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
import com.example.shoesstore.Repository.UserRepository;
import com.example.shoesstore.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class UserServiceImpl implements UserService {
//    private final PasswordEncoder encoder;

    private final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String email, UpdateProfileRequest request) {
        User user = userRepository.findByEmail(email).orElseThrow();
        user.setEmail(request.getEmail());
        user.setUAddress(request.getUAddress());
        user.setUPhone(request.getUPhone());
        user.setUName(request.getUName());
        userRepository.save(user);
        return user;
    }



//    private boolean isUsernameAndEmailUnique(String userName, String email) {
//        return !customerRepository.existsByCusUserOrCusEmail(userName, email);
//    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username){
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Not Found User With email:" + email));
    }
}
