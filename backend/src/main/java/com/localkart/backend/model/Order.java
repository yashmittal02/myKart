package com.localkart.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String customerId;
    private String shopId;
    
    @Column(length = 5000)
    private String itemsJson; // JSON string of cart items
    
    private double totalAmount;
    private String paymentMode; // CASH, ONLINE
    private String paymentStatus; // PENDING, PAID
    
    private String status; // CONFIRMED, PREPARING, PACKING, READY, COMPLETED
    
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
