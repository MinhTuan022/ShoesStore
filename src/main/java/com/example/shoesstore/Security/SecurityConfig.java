//package com.example.shoesstore.Security;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Bỏ qua xác thực cho URL cụ thể
//        http.authorizeRequests()
//                .antMatchers("/api/**").permitAll() // Cho phép truy cập mà không cần xác thực
//                .anyRequest().authenticated(); // Các yêu cầu khác yêu cầu xác thực
//        http.csrf().disable(); // Tắt CSRF trong môi trường phát triển
//    }
//}
//
//
