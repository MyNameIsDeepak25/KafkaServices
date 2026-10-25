package com.example.notificationservice.notification_service.model;

public record OrderEvent(String orderId, String product,int quantity) {
}
