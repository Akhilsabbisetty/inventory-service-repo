package com.ascloud;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@RestController
public class InventoryApp {

    @Autowired
    private StringRedisTemplate redis;

    @GetMapping("/inventory")
    public String inventory() {
        redis.opsForValue().set("stock", "100");
        return redis.opsForValue().get("stock");
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryApp.class, args);
    }
}