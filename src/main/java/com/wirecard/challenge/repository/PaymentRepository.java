package com.wirecard.challenge.repository;

import com.wirecard.challenge.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
