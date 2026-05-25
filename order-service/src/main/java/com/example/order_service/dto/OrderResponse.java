package com.example.order_service.dto;

import java.math.BigDecimal;

public record OrderResponse(
        Long id,
        String productName,
        BigDecimal amount,
        String paymentStatus
) {
}
