package com.wirecard.challenge.dto;

import com.wirecard.challenge.entity.Payment;
import com.wirecard.challenge.entity.PaymentMethod;
import com.wirecard.challenge.entity.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
public record PaymentResponseDTO(
        Long client,
        String name,
        String email,
        String cpf,
        BigDecimal amount,
        PaymentMethod type,
        PaymentStatus status,
        String holderName,
        String cardNumber,
        String expirationDate,
        String cvv
) {
    public PaymentResponseDTO(Payment payment){
        this(
                payment.getClient().getId(),
                payment.getBuyer().getName(),
                payment.getBuyer().getEmail(),
                payment.getBuyer().getCpf(),
                payment.getAmount(),
                payment.getType(),
                payment.getStatus(),
                payment.getCard().getHolderName(),
                payment.getCard().getNumber(),
                payment.getCard().getExpirationDate(),
                payment.getCard().getCvv()
        );

    }
}