package com.tranquangtruong.os.api.service;


import com.tranquangtruong.os.api.common.Payment;
import com.tranquangtruong.os.api.common.TransactionRequest;
import com.tranquangtruong.os.api.common.TransactionResponse;
import com.tranquangtruong.os.api.entity.Order;
import com.tranquangtruong.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
            // rest call
        Payment paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/doPayment",payment,Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success")?"Payment successful and  order placed" :"Failure";

        orderRepository.save(order);


         return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
