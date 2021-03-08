package com.tranquangtruong.ps.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name  = "Payment_Tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private int paymentId;

    private String paymentStatus;

    private String transactionId;

    private int orderId;

    private double amount;
}
