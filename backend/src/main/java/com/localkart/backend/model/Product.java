package com.localkart.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String shopId;
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    private double price;
    private int stockAvailable;
    private boolean isFeatured;
}
