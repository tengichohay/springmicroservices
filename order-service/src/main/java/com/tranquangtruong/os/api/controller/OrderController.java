package com.tranquangtruong.os.api.controller;

import com.tranquangtruong.os.api.common.Payment;
import com.tranquangtruong.os.api.common.TransactionRequest;
import com.tranquangtruong.os.api.common.TransactionResponse;
import com.tranquangtruong.os.api.entity.Order;
import com.tranquangtruong.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {



    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){


        return orderService.saveOrder(request);
    }

    @GetMapping("/bookOrder")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

}
