package com.example.order_service.dto;

import java.math.BigDecimal;

public record PaymentResponse(
        String status,
        BigDecimal amount
) {
}
