package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Customer;
import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
import com.example.shoesstore.Model.Requests.CreateCustomerRequest;
import com.example.shoesstore.Model.Requests.LoginRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    Customer getCustomer(String username);

//    boolean loginCustomer(LoginRequest request);

    Customer loginCustomer(LoginRequest request);
    Customer createCustomer(CreateCustomerRequest request);

    Customer updateCustomer(UpdateProfileRequest request);

    void changePassword(ChangePasswordReqest passwordReqest);
}
