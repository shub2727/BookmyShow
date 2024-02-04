package com.example.BookMyShow_Booking.ExternalService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@FeignClient(name = "FOOD-SERVICE")
public interface FoodService {

    @PostMapping("/api/foods/order")
    public ResponseEntity<Double> OrderFood(@RequestBody Map<String,Integer> foodDto);
}
