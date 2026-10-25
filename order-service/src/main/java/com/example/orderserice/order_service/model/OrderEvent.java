package com.example.orderserice.order_service.model;

public record OrderEvent(String orderId, String product,int quantity) {
}
