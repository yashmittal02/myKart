package com.localkart.backend;

import com.localkart.backend.model.*;
import com.localkart.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LocalKartApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalKartApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:3000")
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}

	@Bean
	public CommandLineRunner initData(ShopRepository shopRepo, ProductRepository productRepo, UserRepository userRepo) {
		return args -> {
			if (userRepo.count() == 0) {
				User owner = new User();
				owner.setName("Yash Merchant");
				owner.setEmail("yash@royalsamosa.com");
				owner.setPassword("admin123");
				owner.setRole(Role.OWNER);
				userRepo.save(owner);

				User testUser = new User();
				testUser.setName("Arjun Sharma");
				testUser.setEmail("arjun@example.com");
				testUser.setPassword("password123");
				testUser.setRole(Role.CUSTOMER);
				userRepo.save(testUser);
			}

			if (shopRepo.count() == 0) {
				User owner = userRepo.findAll().stream()
						.filter(u -> u.getRole() == Role.OWNER)
						.findFirst().orElse(null);

				Shop s1 = new Shop();
				s1.setOwnerId(owner != null ? owner.getId() : "owner-123");
				s1.setName("The Royal Samosa");
				s1.setCategory("Street Delicacies");
				s1.setAddress("12, MG Road, Indiranagar, Bengaluru");
				s1.setCity("Bengaluru");
				s1.setContact("+91 98450 12345");
				s1.setTimings("11:00 - 22:00");
				s1.setOpen(true);
				s1.setPaymentModes("ONLINE, UPI, COUNTER");
				s1.setLatitude(12.9784);
				s1.setLongitude(77.6408);
				s1.setUpiId("royal.samosa@okaxis");
				shopRepo.save(s1);

				Product p1 = new Product();
				p1.setShopId(s1.getId());
				p1.setName("Paneer Tikka Samosa");
				p1.setDescription("Signature fusion samosa served with fresh mint chutney.");
				p1.setPrice(45.00);
				p1.setStockAvailable(50);
				p1.setFeatured(true);
				productRepo.save(p1);

				Shop s2 = new Shop();
				s2.setName("Mumbai Spice Hub");
				s2.setCategory("Organic Spices");
				s2.setAddress("Crawford Market, South Mumbai");
				s2.setCity("Mumbai");
				s2.setContact("+91 91234 56789");
				s2.setTimings("10:00 - 20:00");
				s2.setOpen(true);
				s2.setPaymentModes("COUNTER, UPI");
				s2.setLatitude(18.9482);
				s2.setLongitude(72.8347);
				s2.setUpiId("mumbai.spices@okicici");
				shopRepo.save(s2);

				Product p2 = new Product();
				p2.setShopId(s2.getId());
				p2.setName("Rajma Masala Mix");
				p2.setDescription("Hand-ground organic spice blend, no preservatives.");
				p2.setPrice(280.00);
				p2.setStockAvailable(30);
				p2.setFeatured(false);
				productRepo.save(p2);

				Shop s3 = new Shop();
				s3.setName("Delhi Mithai Wala");
				s3.setCategory("Traditional Sweets");
				s3.setAddress("Shop 7, Chandni Chowk, Old Delhi");
				s3.setCity("Delhi");
				s3.setContact("+91 88001 23456");
				s3.setTimings("09:00 - 21:00");
				s3.setOpen(true);
				s3.setPaymentModes("ONLINE, COUNTER");
				s3.setLatitude(28.6657);
				s3.setLongitude(77.2307);
				s3.setUpiId("delhi.mithai@oksbi");
				shopRepo.save(s3);

				Product p3 = new Product();
				p3.setShopId(s3.getId());
				p3.setName("Kaju Katli (500g)");
				p3.setDescription("Premium quality kaju katli, made fresh daily.");
				p3.setPrice(600.00);
				p3.setStockAvailable(20);
				p3.setFeatured(true);
				productRepo.save(p3);
			}
		};
	}
}
