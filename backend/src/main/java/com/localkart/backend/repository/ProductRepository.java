package com.localkart.backend.repository;

import com.localkart.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByShopId(String shopId);
}
