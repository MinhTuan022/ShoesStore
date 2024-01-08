package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Customer;
import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
import com.example.shoesstore.Model.Requests.CreateCustomerRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
import com.example.shoesstore.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    CustomerService customerService;

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

    @GetMapping("/login")
    ResponseEntity<Customer> getCustomer(@RequestParam("username") String username){
        Customer customer = customerService.getCustomer(username);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/rePassword")
    ResponseEntity<String> changePassword(@RequestBody ChangePasswordReqest passwordReqest){
        customerService.changePassword(passwordReqest);
        return ResponseEntity.ok("Cập nhật pass thành công");
    }
}
