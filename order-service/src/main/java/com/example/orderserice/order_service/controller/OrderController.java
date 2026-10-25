package com.example.orderserice.order_service.controller;

import com.example.orderserice.order_service.model.OrderEvent;
import com.example.orderserice.order_service.service.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEvent event){
        orderProducer.sendOrder(event);
        return ResponseEntity.accepted().body(
                "order received " + event.orderId()
        );
    }
}
