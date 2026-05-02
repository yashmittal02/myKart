package com.localkart.backend.repository;

import com.localkart.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, String> {
    List<Review> findByShopId(String shopId);
}
