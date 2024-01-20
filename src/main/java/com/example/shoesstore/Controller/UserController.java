package com.example.shoesstore.Controller;

//import com.example.shoesstore.Entity.User;
//import com.example.shoesstore.Model.Requests.ChangePasswordReqest;
//import com.example.shoesstore.Model.Requests.CreateUserRequest;
//import com.example.shoesstore.Model.Requests.LoginRequest;
//import com.example.shoesstore.Model.Requests.UpdateProfileRequest;
//import com.example.shoesstore.Security.Jwt.JwtUtils;
//import com.example.shoesstore.Security.Service.UserDetailsServiceImpl;
//import com.example.shoesstore.Service.UserService;
import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    UserService userService;

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi(){
        return ResponseEntity.ok("Hi User");
    }

    @GetMapping
    ResponseEntity<User> getUser(@RequestParam("email") String email){
        User user = userService.getUser(email);
        return ResponseEntity.ok(user);
    }
//    @GetMapping
//    ResponseEntity<List<User>> getAllCustomer(){
//        List<User> customerList = customerService.getAllCustomer();
//        return ResponseEntity.ok(customerList);
//    }
//
//
//    @PutMapping("/update")
//    ResponseEntity<User> updateCustomer(UpdateProfileRequest request){
//        User customer = customerService.updateCustomer(request);
//        return ResponseEntity.ok(customer);
//    }
//

//    @PutMapping("/rePassword")
//    ResponseEntity<String> changePassword(@RequestBody ChangePasswordReqest passwordReqest){
//        customerService.changePassword(passwordReqest);
//        return ResponseEntity.ok("Cập nhật pass thành công");
//    }
}
