package com.localkart.backend.controller;

import com.localkart.backend.model.*;
import com.localkart.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopRepository shopRepository;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return Map.of(
                "success", true,
                "user", user.get()
            );
        }
        return Map.of("success", false, "message", "Invalid credentials");
    }

    @PostMapping("/register-user")
    public Map<String, Object> registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return Map.of("success", false, "message", "Email already exists");
        }
        user.setRole(Role.CUSTOMER);
        User saved = userRepository.save(user);
        return Map.of("success", true, "user", saved);
    }

    @PostMapping("/register-shop")
    public Map<String, Object> registerShop(@RequestBody Map<String, Object> data) {
        String email = (String) data.get("email");
        if (userRepository.findByEmail(email).isPresent()) {
            return Map.of("success", false, "message", "Email already exists");
        }

        User user = new User();
        user.setName((String) data.get("ownerName"));
        user.setEmail(email);
        user.setPassword((String) data.get("password"));
        user.setRole(Role.OWNER);
        User savedUser = userRepository.save(user);

        Shop shop = new Shop();
        shop.setOwnerId(savedUser.getId());
        shop.setName((String) data.get("shopName"));
        shop.setCategory((String) data.get("category"));
        shop.setAddress((String) data.get("address"));
        shop.setCity((String) data.get("city"));
        shop.setContact((String) data.get("contact"));
        shop.setTimings("09:00 - 21:00");
        shop.setOpen(true);
        shopRepository.save(shop);

        return Map.of("success", true, "user", savedUser, "shop", shop);
    }
}
