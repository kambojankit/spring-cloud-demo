package com.techarha.demo.review.controller;

import com.techarha.demo.review.model.Review;
import com.techarha.demo.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public ResponseEntity createReview(@Validated @RequestBody Review review) {
        reviewRepository.save(review);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviewList = reviewRepository.findAll();
        return new ResponseEntity(reviewList, HttpStatus.OK);
    }

    @GetMapping("/search/name/{userName}")
    public ResponseEntity<List<Review>> getReviewByUserName(@PathVariable String userName) {
        List<Review> reviewList = reviewRepository.findByUserName(userName);
        return new ResponseEntity(reviewList, HttpStatus.OK);
    }

    @GetMapping("/search/productId/{productId}")
    public ResponseEntity<List<Review>> getReviewByReviewName(@PathVariable Long productId) {
        List<Review> reviewList = reviewRepository.findByProductId(productId);
        return new ResponseEntity(reviewList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateReview(@Validated @RequestBody Review review) {
        Review c = reviewRepository.save(review);
        return new ResponseEntity(c.getId(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity deleteReview(@PathVariable Long reviewId) {
        reviewRepository.deleteById(reviewId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
