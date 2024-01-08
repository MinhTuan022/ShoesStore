package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Customer;
import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
import com.example.shoesstore.Model.Requests.CreateCustomerRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    Customer getCustomer(String username);

    Customer createCustomer(CreateCustomerRequest request);

    Customer updateCustomer(UpdateProfileRequest request);

    void changePassword(ChangePasswordReqest passwordReqest);
}
