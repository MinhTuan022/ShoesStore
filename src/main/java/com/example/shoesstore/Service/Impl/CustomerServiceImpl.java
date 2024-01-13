package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Customer;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
import com.example.shoesstore.Model.Requests.CreateCustomerRequest;
import com.example.shoesstore.Model.Requests.LoginRequest;
import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
import com.example.shoesstore.Repository.CustomerRepository;
import com.example.shoesstore.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    PasswordEncoder encoder;
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    @Override
    public Customer getCustomer(String username) {
        Customer customer = customerRepository.findByCusUser(username).orElseThrow(()-> new ResourceNotFoundException("Not Found Customer With Username:" + username));
        return customer;
    }

    @Override
    public Customer loginCustomer(LoginRequest request) {
        Customer customer = customerRepository.findCustomerByCusUser(request.getCusUser());
        return  customer;
    }

//    @Override
//    public boolean loginCustomer(LoginRequest request) {
//        Optional<Customer> customerOptional = customerRepository.findByCusUser(request.getCusUser());
//        if(customerOptional.isPresent()){
//            Customer customer = customerOptional.get();
//
//            return encoder.matches(request.getCusPass(), customer.getCusPass());
//
//        }
//        return false;
//    }



    @Override
    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setCusUser(request.getCusUser());
        customer.setCusPass(encoder.encode(request.getCusPass()));
        customer.setCusEmail(request.getCusEmail());
        if (isUsernameAndEmailUnique(request.getCusUser(), request.getCusEmail())) {
            return customerRepository.save(customer);
        } else {
            throw new DuplicateKeyException("Username or Email already exists");
        }
    }

    @Override
    public Customer updateCustomer(UpdateProfileRequest request) {
        Customer customer = new Customer();
        customer.setCusUser(request.getCusUser());
        customer.setCusPass(encoder.encode(request.getCusPass()));
        customer.setCusAddress(request.getCusAddress());
        customer.setCusPhone(request.getCusPhone());
        customer.setCusEmail(request.getCusEmail());
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void changePassword(ChangePasswordReqest passwordReqest) {
        Customer customer = customerRepository.findByCusUser(passwordReqest.getCusUser()).orElseThrow(()-> new ResourceNotFoundException("Not Found Customer With Username:" + passwordReqest.getCusUser()));
        if(Objects.equals(encoder.encode(passwordReqest.getOldPass()), customer.getCusPass())){
            customer.setCusPass(encoder.encode(passwordReqest.getNewPass()));
        }
        customerRepository.save(customer);
    }

    private boolean isUsernameAndEmailUnique(String userName, String email) {
        return !customerRepository.existsByCusUserOrCusEmail(userName, email);
    }

}
