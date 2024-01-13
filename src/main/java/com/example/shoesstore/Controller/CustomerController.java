package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Customer;
import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
import com.example.shoesstore.Model.Requests.CreateCustomerRequest;
import com.example.shoesstore.Model.Requests.LoginRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
import com.example.shoesstore.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    CustomerService customerService;

    AuthenticationManager authenticationManager;

    @GetMapping
    ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomer();
        return ResponseEntity.ok(customerList);
    }

    @PostMapping("/register")
    ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest request){
        Customer customer = customerService.createCustomer(request);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/update")
    ResponseEntity<Customer> updateCustomer(UpdateProfileRequest request){
        Customer customer = customerService.updateCustomer(request);
        return ResponseEntity.ok(customer);
    }

//    @GetMapping("/login")
//    ResponseEntity<Customer> getCustomer(@RequestParam("username")  String username){
//        Customer customer = customerService.getCustomer(username);
//        return ResponseEntity.ok(customer);
//    }

    @PostMapping("/login")
    ResponseEntity<Customer> getCustomer(@RequestBody LoginRequest request){
//        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                request.getCusUser(), request.getCusPass()
//        ));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
////        boolean isAuthenticated = customerService.loginCustomer(request);
////        if (isAuthenticated) {
////            return ResponseEntity.ok("Login successful");
////        } else {
////            return ResponseEntity.ok("Login failed");
////        }
//        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
        Customer customer =customerService.loginCustomer(request);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/rePassword")
    ResponseEntity<String> changePassword(@RequestBody ChangePasswordReqest passwordReqest){
        customerService.changePassword(passwordReqest);
        return ResponseEntity.ok("Cập nhật pass thành công");
    }
}
