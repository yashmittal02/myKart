package com.localkart.backend.controller;

import com.localkart.backend.model.Product;
import com.localkart.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/shop/{shopId}")
    public List<Product> getProductsByShop(@PathVariable String shopId) {
        return productRepository.findByShopId(shopId);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String q) {
        return productRepository.findAll().stream()
                .filter(p -> p.getName().toLowerCase().contains(q.toLowerCase()) || 
                             p.getDescription().toLowerCase().contains(q.toLowerCase()))
                .toList();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }
}
