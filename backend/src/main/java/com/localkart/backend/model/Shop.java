package com.localkart.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String ownerId;
    private String name;
    private String address;
    private String city;
    private String contact;
    private String timings;
    private boolean isOpen;
    private String category;
    private String paymentModes;
    
    // Coordinates for real maps
    private double latitude;
    private double longitude;
    
    // Shop-wise payment
    private String upiId; 
}
