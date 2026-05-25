package com.example.payment_service.controller;


import com.example.payment_service.dto.PaymentRequest;
import com.example.payment_service.dto.PaymentResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@Valid @RequestBody PaymentRequest request) {
        String status = request.amount().compareTo(BigDecimal.valueOf(10_000)) > 0
                ? "DECLINED"
                : "APPROVED";

        PaymentResponse response = new PaymentResponse(status, request.amount());

        return ResponseEntity.ok(response);
    }

}
