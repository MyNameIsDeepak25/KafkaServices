package com.example.notificationservice.notification_service.service;

import com.example.notificationservice.notification_service.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(
            topics = "order-events-v2",
            groupId = "notification-group"
    )
    public void consumeOrderEvent(OrderEvent event) {

        System.out.println("Received order event from Kafka");
        System.out.println("Order ID: " + event.orderId());
        System.out.println("Product: " + event.product());
        System.out.println("Quantity: " + event.quantity());

        System.out.println(
                "Sending notification for order: " + event.orderId()
        );
    }
}
