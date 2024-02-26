package com.js.polarbookshop.orderservice.order.web;

import javax.validation.Valid;
import com.js.polarbookshop.orderservice.order.domain.Order;
import com.js.polarbookshop.orderservice.order.domain.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("orders")
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @PostMapping
    public Mono<Order> submitOrder(
        @RequestBody @Valid OrderRequest orderRequest
    ){
        return orderService.submitOrder(
            orderRequest.isbn(), orderRequest.quantity()
        );
    }
}

