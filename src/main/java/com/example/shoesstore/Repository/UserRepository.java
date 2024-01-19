package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Role;
import com.example.shoesstore.Entity.User;
//import com.example.shoesstore.Security.Service.Impl.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
//    User findCustomerByCusUser(String username);
//    User findCustomerByCusUserAndCusPass(String username, String password);
//    Boolean existsByCusUserOrCusEmail(String userName, String email);.
    User findByRole(Role role);
}
