package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.*;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Model.Requests.CreateOrderDetailRequest;
import com.example.shoesstore.Model.Requests.CreateOrderRequest;
import com.example.shoesstore.Repository.OrderDetailRepository;
import com.example.shoesstore.Repository.OrderRepository;
import com.example.shoesstore.Repository.PaymentRepository;
import com.example.shoesstore.Repository.UserRepository;
import com.example.shoesstore.Service.OrderService;
import com.example.shoesstore.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    UserRepository userRepository;
    ProductService productService;
    PaymentRepository paymentRepository;
    OrderDetailRepository orderDetailRepository;
    OrderRepository orderRepository;
    @Override
    public void placeOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setOrdPhone(request.getOrdPhone());
        order.setOrdShipDate(getDateTime(LocalDateTime.now().plus(Duration.ofDays(7))));
        order.setOrdAddress(request.getOrdAddress());
        order.setOrdDate(getDateTime(LocalDateTime.now()));
        order.setOrdReceiver(request.getOrdReceiver());

        PaymentMethod paymentMethod = paymentRepository.findById(request.getPayId()).orElseThrow(() -> new ResourceNotFoundException("Not Found Payment with Id: " + request.getPayId()));
        order.setPaymentMethod(paymentMethod);

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Not Found User With email:" + request.getEmail()));

        orderRepository.save(order);
        long totalPrice = 0;
        for(CreateOrderDetailRequest rq:  request.getOrderDetailList()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setSize(rq.getSize());
            orderDetail.setQuantity(rq.getQuantity());
            Product product = productService.getProductById(rq.getProId());
            orderDetail.setProduct(product);
//            if (product.getProBasisPrice() > 0){
                orderDetail.setSubTotal(rq.getQuantity() * product.getProPrice());
//            }else {
//                orderDetail.setSubTotal(rq.getQuantity() * product.getProBasisPrice());
//            }
            orderDetail.setOrder(order);
            totalPrice += orderDetail.getSubTotal();
            orderDetailRepository.save(orderDetail);


        }
        order.setOrdTotal(totalPrice);
        order.setUser(user);
        orderRepository.save(order);


    }

    @Override
    public void updateOrder(Long ordId, CreateOrderRequest request) {
//        Order order = orderRepository.findById(ordId).orElseThrow();
//        order.setOrdPhone(request.getOrdPhone());
//        order.setOrdShipDate(getDateTime(LocalDateTime.now().plus(Duration.ofDays(7))));
//        order.setOrdAddress(request.getOrdAddress());
//        order.setOrdDate(getDateTime(LocalDateTime.now()));
//        order.setOrdReceiver(request.getOrdReceiver());
//
//        PaymentMethod paymentMethod = paymentRepository.findById(request.getPayId()).orElseThrow(() -> new ResourceNotFoundException("Not Found Payment with Id: " + request.getPayId()));
//        order.setPaymentMethod(paymentMethod);
//
//        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Not Found User With email:" + request.getEmail()));
//
//        orderRepository.save(order);
//        long totalPrice = 0;
//        for(CreateOrderDetailRequest rq:  request.getOrderDetailList()){
//            OrderDetail orderDetail = orderRepository.findBy();
//            orderDetail.setSize(rq.getSize());
//            orderDetail.setQuantity(rq.getQuantity());
//            Product product = productService.getProductById(rq.getProId());
//            orderDetail.setProduct(product);
////            if (product.getProBasisPrice() > 0){
//            orderDetail.setSubTotal(rq.getQuantity() * product.getProPrice());
////            }else {
////                orderDetail.setSubTotal(rq.getQuantity() * product.getProBasisPrice());
////            }
//            orderDetail.setOrder(order);
//            totalPrice += orderDetail.getSubTotal();
//            orderDetailRepository.save(orderDetail);
//
//
//        }
//        order.setOrdTotal(totalPrice);
//        order.setUser(user);
//        orderRepository.save(order);
    }

    @Override
    public List<Order> listOrderByUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Not Found User"));
        List<Order> orders = orderRepository.getOrderByUser(user.getUId());
        return orders;
    }

    public String getDateTime(LocalDateTime DateF) {
        // Lấy ngày giờ hiện tại
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return DateF.format(formatter);
    }
}
