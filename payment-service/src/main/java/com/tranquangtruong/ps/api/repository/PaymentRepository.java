package com.tranquangtruong.ps.api.repository;

import com.tranquangtruong.ps.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Integer> {
}
