package com.example.shoesstore.Model.Requests;

import com.example.shoesstore.Entity.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileRequest {
    private String email;
    private String uName;
    private String uPhone;
    private String uAddress;
}
