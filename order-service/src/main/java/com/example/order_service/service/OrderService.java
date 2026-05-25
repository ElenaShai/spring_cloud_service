package com.example.order_service.service;

import com.example.order_service.client.PaymentClient;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.dto.OrderResponse;
import com.example.order_service.dto.PaymentRequest;
import com.example.order_service.dto.PaymentResponse;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentClient paymentClient;

    public OrderResponse createOrder(OrderRequest request) {
        PaymentResponse paymentResponse = paymentClient.createPayment(
                new PaymentRequest(request.amount())
        );

        Order order = Order.builder()
                .productName(request.productName())
                .amount(request.amount())
                .paymentStatus(paymentResponse.status())
                .build();

        Order savedOrder = orderRepository.save(order);

        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getAmount(),
                savedOrder.getPaymentStatus()
        );
    }
}
