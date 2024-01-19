package com.example.shoesstore;

import com.example.shoesstore.Entity.Role;
import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShoesStoreApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(ShoesStoreApplication.class, args);
    }

    public void run(String... args){
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if(adminAccount == null){
            User user = new User();

            user.setUsername("admin");
            user.setUEmail("admin@gmail.com");
            user.setRole(Role.ADMIN);
            user.setUAddress("HY");
            user.setUPhone("0123456789");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }

}
