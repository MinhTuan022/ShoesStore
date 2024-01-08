package com.example.shoesstore.Model.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileRequest {
    private String cusUser;
    private String cusPass;
    private String cusPhone;
    private String cusAddress;
    private String cusEmail;
}
