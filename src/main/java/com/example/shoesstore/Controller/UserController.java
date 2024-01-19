package com.example.shoesstore.Controller;

//import com.example.shoesstore.Entity.User;
//import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
//import com.example.shoesstore.Model.Requests.CreateUserRequest;
//import com.example.shoesstore.Model.Requests.LoginRequest;
//import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
//import com.example.shoesstore.Security.Jwt.JwtUtils;
//import com.example.shoesstore.Security.Service.UserDetailsServiceImpl;
//import com.example.shoesstore.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

//import java.util.List;
//
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
//    UserService customerService;
//    UserDetailsServiceImpl userDetailsService;
//
//    AuthenticationManager authenticationManager;
//    private JwtUtils jwtUtils;
//
    @GetMapping
    public ResponseEntity<String> sayHi(){
        return ResponseEntity.ok("Hi User");
    }
//    @GetMapping
//    ResponseEntity<List<User>> getAllCustomer(){
//        List<User> customerList = customerService.getAllCustomer();
//        return ResponseEntity.ok(customerList);
//    }
//
//    @PostMapping("/register")
//    ResponseEntity<User> createCustomer(@RequestBody CreateUserRequest request){
//        User customer = customerService.createCustomer(request);
//        return ResponseEntity.ok(customer);
//    }
//
//    @PutMapping("/update")
//    ResponseEntity<User> updateCustomer(UpdateProfileRequest request){
//        User customer = customerService.updateCustomer(request);
//        return ResponseEntity.ok(customer);
//    }
//
////    @GetMapping("/login")
////    ResponseEntity<Customer> getCustomer(@RequestParam("username")  String username){
////        Customer customer = customerService.getCustomer(username);
////        return ResponseEntity.ok(customer);
////    }
//
//    @PostMapping("/login")
//    ResponseEntity<?> getCustomer(@RequestBody LoginRequest request) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                request.getCusUser(), request.getCusPass()
//        ));
////
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//////        boolean isAuthenticated = customerService.loginCustomer(request);
//////        if (isAuthenticated) {
//////            return ResponseEntity.ok("Login successful");
//////        } else {
//////            return ResponseEntity.ok("Login failed");
//////        }
////        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
////        Customer customer =customerService.loginCustomer(request);
////        return ResponseEntity.ok(customer);
//        // Tạo JWT từ thông tin xác thực
////        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getCusUser());
//        String token = jwtUtils.generateTokenFromUsername(request.getCusUser());
//
//        // Tạo và trả về response chứa token
////        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
//
//        return ResponseEntity.status(HttpStatus.OK).body("{\"token\": \"" + token + "\"}");
//
//    }
//    @PutMapping("/rePassword")
//    ResponseEntity<String> changePassword(@RequestBody ChangePasswordReqest passwordReqest){
//        customerService.changePassword(passwordReqest);
//        return ResponseEntity.ok("Cập nhật pass thành công");
//    }
}
