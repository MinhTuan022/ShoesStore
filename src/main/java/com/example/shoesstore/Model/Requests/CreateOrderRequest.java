package com.example.shoesstore.Model.Requests;

import com.example.shoesstore.Entity.OrderDetail;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private String ordAddress;
    private String ordPhone;
    private String ordReceiver;
    private long ordTotal;
    private String email;
    private long payId;
    private List<CreateOrderDetailRequest> orderDetailList;
}
