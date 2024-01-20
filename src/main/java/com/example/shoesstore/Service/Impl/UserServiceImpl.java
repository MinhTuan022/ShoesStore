package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Repository.UserRepository;
import com.example.shoesstore.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
//    PasswordEncoder encoder;
//    @Override
//    public List<User> getAllCustomer() {
//        List<User> customerList = customerRepository.findAll();
//        return customerList;
//    }
//
//    @Override
//    public User getCustomer(String username) {
//        User customer = customerRepository.findByCusUser(username).orElseThrow(()-> new ResourceNotFoundException("Not Found Customer With Username:" + username));
//        return customer;
//    }
//
//    @Override
//    public User loginCustomer(LoginRequest request) {
//        User customer = customerRepository.findCustomerByCusUser(request.getCusUser());
//        return  customer;
//    }
//
////    @Override
////    public boolean loginCustomer(LoginRequest request) {
////        Optional<Customer> customerOptional = customerRepository.findByCusUser(request.getCusUser());
////        if(customerOptional.isPresent()){
////            Customer customer = customerOptional.get();
////
////            return encoder.matches(request.getCusPass(), customer.getCusPass());
////
////        }
////        return false;
////    }
//
//
//
//    @Override
//    public User createCustomer(CreateUserRequest request) {
//        User customer = new User();
//        customer.setCusUser(request.getCusUser());
//        customer.setCusPass(encoder.encode(request.getCusPass()));
//        customer.setCusEmail(request.getCusEmail());
//        if (isUsernameAndEmailUnique(request.getCusUser(), request.getCusEmail())) {
//            return customerRepository.save(customer);
//        } else {
//            throw new DuplicateKeyException("Username or Email already exists");
//        }
//    }
//
//    @Override
//    public User updateCustomer(UpdateProfileRequest request) {
//        User user = new User();
//        customer.getUsername(request.getCusUser());
//        customer.setCusPass(encoder.encode(request.getCusPass()));
//        customer.setCusAddress(request.getCusAddress());
//        customer.setCusPhone(request.getCusPhone());
//        customer.setCusEmail(request.getCusEmail());
//        customerRepository.save(customer);
//        return customer;
//    }
//
//    @Override
//    public void changePassword(ChangePasswordReqest passwordReqest) {
//        User customer = customerRepository.findByCusUser(passwordReqest.getCusUser()).orElseThrow(()-> new ResourceNotFoundException("Not Found Customer With Username:" + passwordReqest.getCusUser()));
//        if(Objects.equals(encoder.encode(passwordReqest.getOldPass()), customer.getCusPass())){
//            customer.setCusPass(encoder.encode(passwordReqest.getNewPass()));
//        }
//        customerRepository.save(customer);
//    }
//
//    private boolean isUsernameAndEmailUnique(String userName, String email) {
//        return !customerRepository.existsByCusUserOrCusEmail(userName, email);
//    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email){
                return userRepository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("Not Found User With email:" + email));
    }
}
