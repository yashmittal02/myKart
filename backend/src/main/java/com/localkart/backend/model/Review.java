package com.localkart.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private String id = UUID.randomUUID().toString();
    
    private String shopId;
    private String customerId;
    private String customerName;
    private String comment;
    private int rating; // 1-5
    private LocalDateTime createdAt = LocalDateTime.now();
}
