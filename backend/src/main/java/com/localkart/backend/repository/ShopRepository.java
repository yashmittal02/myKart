package com.localkart.backend.repository;

import com.localkart.backend.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, String> {
    List<Shop> findByOwnerId(String ownerId);
    List<Shop> findByCategory(String category);
}
