package com.localkart.backend.controller;

import com.localkart.backend.model.Order;
import com.localkart.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @GetMapping("/shop/{shopId}")
    public List<Order> getOrdersByShop(@PathVariable String shopId) {
        return orderRepository.findByShopId(shopId);
    }

    @PatchMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable String id, @RequestBody String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            // Remove any surrounding quotes from the status string
            String cleanStatus = status.trim();
            if (cleanStatus.startsWith("\"") && cleanStatus.endsWith("\"")) {
                cleanStatus = cleanStatus.substring(1, cleanStatus.length() - 1);
            }
            order.setStatus(cleanStatus);
            order.setUpdatedAt(LocalDateTime.now());
            return orderRepository.save(order);
        }
        return null;
    }
}
