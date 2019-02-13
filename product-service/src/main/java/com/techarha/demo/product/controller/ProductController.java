package com.techarha.demo.product.controller;

import com.techarha.demo.product.model.Product;
import com.techarha.demo.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity createProduct(@Validated @RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity(productList, HttpStatus.OK);
    }

    @GetMapping("/search/name/{productName}")
    public ResponseEntity<List<Product>> getProductByProductName(@PathVariable String productName) {
        List<Product> productList = productRepository.findByProductName(productName);
        return new ResponseEntity(productList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateProduct(@Validated @RequestBody Product product) {
        Product c = productRepository.save(product);
        return new ResponseEntity(c.getId(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productRepository.deleteById(productId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
