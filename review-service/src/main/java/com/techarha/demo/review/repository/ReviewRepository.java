package com.techarha.demo.review.repository;

import com.techarha.demo.review.model.Review;;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserName(String userName);
    List<Review> findByProductId(Long productId);
}
