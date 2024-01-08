package com.example.shoesstore.Model.Requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordReqest {
    @NotNull(message="Username rỗng")
    @NotEmpty(message="Username rỗng")
    @Size(min=5,max=30,message="Username từ 5-30 ký tự")
    private String cusUser;

    @NotNull(message="Mật khẩu rỗng")
    @NotEmpty(message="Mật khẩu rỗng")
    @Size(min=6,max=30,message="Mật khẩu từ 6-30 ký tự")
    private String oldPass;

    @NotNull(message="Mật khẩu rỗng")
    @NotEmpty(message="Mật khẩu rỗng")
    @Size(min=6,max=30,message="Mật khẩu từ 6-30 ký tự")
    private String newPass;
}
