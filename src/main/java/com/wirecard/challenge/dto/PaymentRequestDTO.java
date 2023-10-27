package com.wirecard.challenge.dto;

import com.wirecard.challenge.entity.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentRequestDTO(
        @NotBlank
        Long idClient,
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        BigDecimal amount,
        @NotNull
        PaymentMethod type,
        @NotNull
        @Valid
        CardDTO card

) {
}
