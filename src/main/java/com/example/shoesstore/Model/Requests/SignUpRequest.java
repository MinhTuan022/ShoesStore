package com.example.shoesstore.Model.Requests;

import com.example.shoesstore.Entity.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private String username;
    private String password;
    private String uEmail;
    private String uPhone;
    private String uAddress;
}
