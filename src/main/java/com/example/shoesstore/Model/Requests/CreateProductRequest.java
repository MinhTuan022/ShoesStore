package com.example.shoesstore.Model.Requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {
    @NotNull(message = "Tên sản phẩm rỗng")
    @NotEmpty(message = "Tên Sản Phẩm Rỗng")
    @Size(min=5,max=50,message="Tên sản phẩm từ 3-50 ký tự")
    private String proName;

    @NotNull(message = "Giá tiền rỗng")
    @NotEmpty(message = "Giá tiền rỗng")
    @Size(min=0,message="Giá tiền sản phẩm lớn hơn 0")
    private Double proPrice;

    @NotNull(message = "Giá tiền rỗng")
    @NotEmpty(message = "Giá tiền rỗng")
    @Size(min=0,message="Giá tiền sản phẩm lớn hơn 0")
    private Double proBasisPrice;

    private Date proDate;
    private boolean proHot;
    private boolean proState;

    @NotNull(message = "Mô tả rỗng")
    @NotEmpty(message="Mô tả rỗng")
    @Size(min=5,max=1000,message="Mô tả sản phẩm từ 5-1000 ký tự")
    private String proDescription;

    @NotNull(message = "Số lượng sản phẩm")
    @NotEmpty(message="Số lượng sản phẩm")
    @Size(min=0,message="Số lượng sản phẩm từ 0")
    private int proQuantity;

    @NotNull(message = "Danh mục rỗng")
    @NotEmpty(message = "Danh mục rỗng")
    private long cateId;

    @NotNull(message = "Thuơng hiệu rỗng")
    @NotEmpty(message = "Thương hiệu rỗng")
    private long braId;

    @NotNull(message="Ảnh sản phẩm rỗng")
    private Set<Long> imgId;

}
