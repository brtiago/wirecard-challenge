package com.wirecard.challenge.controller;

import com.wirecard.challenge.dto.PaymentListByIdDTO;
import com.wirecard.challenge.dto.PaymentRequestDTO;
import com.wirecard.challenge.dto.PaymentResponseDTO;
import com.wirecard.challenge.entity.Payment;
import com.wirecard.challenge.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Transactional
    @Operation(summary = "To process a payment for a costumer")
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> create(@RequestBody PaymentRequestDTO dto) throws Exception {
        Payment payment = paymentService.createPayment(dto);
        PaymentResponseDTO response = new PaymentResponseDTO(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
     }

    @Operation(summary = "List all payments")
    @GetMapping
    public ResponseEntity<List<PaymentListByIdDTO>> listAll() {
        List<PaymentListByIdDTO> paymentListDTOs = paymentService.listAll()
                .stream()
                .map(payment -> new PaymentListByIdDTO(payment))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(paymentListDTOs);
    }



}
