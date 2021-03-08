package com.tranquangtruong.os.api.common;

import com.tranquangtruong.os.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private Order order;

    private double amount;

    private String transactionId;

    private String message;
}
