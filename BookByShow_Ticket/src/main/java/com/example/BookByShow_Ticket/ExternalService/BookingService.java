package com.example.BookByShow_Ticket.ExternalService;

import com.example.BookByShow_Ticket.ApiConstant.Constants;

import com.example.BookByShow_Ticket.Entity.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingService {

    @GetMapping("/api/booking/{id}")
    public ResponseEntity<Booking> getBookingId(@PathVariable String id);
}
