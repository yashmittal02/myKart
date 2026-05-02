package com.localkart.backend.controller;

import com.localkart.backend.model.Shop;
import com.localkart.backend.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shops")
@CrossOrigin(origins = "*")
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable String id) {
        return shopRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Shop createShop(@RequestBody Shop shop) {
        return shopRepository.save(shop);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Shop> getShopsByOwner(@PathVariable String ownerId) {
        return shopRepository.findByOwnerId(ownerId);
    }

    /** Returns a deduplicated, sorted list of cities that have at least one registered shop. */
    @GetMapping("/cities")
    public List<String> getCities() {
        return shopRepository.findAll().stream()
                .map(Shop::getCity)
                .filter(c -> c != null && !c.isBlank())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
