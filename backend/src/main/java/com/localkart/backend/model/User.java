package com.localkart.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String name;
    private String email;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role; // CUSTOMER or OWNER
    
    private LocalDateTime createdAt = LocalDateTime.now();
}
