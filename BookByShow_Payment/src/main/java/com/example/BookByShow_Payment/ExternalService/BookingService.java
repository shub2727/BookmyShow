package com.example.BookByShow_Payment.ExternalService;


import com.example.BookByShow_Payment.Dto.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingService {

    @GetMapping("/api/booking/{id}")
    public ResponseEntity<Booking> getBookingId(@PathVariable String id);
}
