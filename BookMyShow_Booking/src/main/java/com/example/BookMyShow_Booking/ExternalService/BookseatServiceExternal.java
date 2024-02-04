package com.example.BookMyShow_Booking.ExternalService;

import com.example.BookMyShow_Booking.Entity.BookSeats;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "BOOKING-SERVICE")
public interface BookseatServiceExternal {

    @PostMapping("/api/bookseat/")
    ResponseEntity<BookSeats> createBookingSeat(@RequestBody BookSeats bookSeats);
}
