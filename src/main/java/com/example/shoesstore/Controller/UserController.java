package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Model.Requests.ChangePasswordRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
import com.example.shoesstore.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi(){
        return ResponseEntity.ok("Hi User");
    }

    @GetMapping("/user")
    ResponseEntity<User> getUser(@RequestParam("email") String email){
        User user = userService.getUser(email);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    ResponseEntity<List<User>> getAlUser(){
        List<User> customerList = userService.getAllUser();
        return ResponseEntity.ok(customerList);
    }


    @PutMapping("/update")
    ResponseEntity<User> updateUser(@RequestParam("email") String email,@RequestBody UpdateProfileRequest request){
        User customer = userService.updateUser(email, request);
        return ResponseEntity.ok(customer);
    }



}
