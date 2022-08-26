package io.applifting.jbtesting.controller;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return null;
    }

    @PostMapping("/neworder")
    public Order createNewOrder(@RequestBody Order newOrder){
        return null;
    }

}
