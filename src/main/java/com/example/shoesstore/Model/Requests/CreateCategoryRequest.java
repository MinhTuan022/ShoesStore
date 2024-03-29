package com.example.shoesstore.Model.Requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {
    @NotNull(message = "Tên danh mục rỗng")
    @NotEmpty(message = "Tên danh mục rỗng")
    @Size(min=2,max=50,message="Độ dài danh mục từ 5-50 ký tự")
    private String cateName;
}
