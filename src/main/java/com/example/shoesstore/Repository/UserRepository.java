package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Role;

//import com.example.shoesstore.Security.Service.Impl.UserDetailsImpl;

import com.example.shoesstore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

//    @Query(value ="Select * from User where username = username",nativeQuery = true)
//    User getUserByUsername(String username);
//    User findCustomerByCusUserAndCusPass(String username, String password);
//    Boolean existsByCusUserOrCusEmail(String userName, String email);.
    User findByRole(Role role);
}
