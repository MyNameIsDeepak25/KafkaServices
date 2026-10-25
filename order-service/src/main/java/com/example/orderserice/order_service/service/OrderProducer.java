package com.example.orderserice.order_service.service;

import com.example.orderserice.order_service.model.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static  final String TOPIC = "order-events-v2";
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;


    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(OrderEvent event){
        kafkaTemplate.send(TOPIC,event.orderId(),event);
    }
}
