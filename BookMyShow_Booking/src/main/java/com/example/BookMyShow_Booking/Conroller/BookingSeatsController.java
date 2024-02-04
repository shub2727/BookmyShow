package com.example.BookMyShow_Booking.Conroller;

import com.example.BookMyShow_Booking.Entity.BookSeats;
import com.example.BookMyShow_Booking.Service.BookSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookseat")
public class BookingSeatsController {

    @Autowired
    BookSeatService  bookSeatService;


    @PostMapping("/")
    ResponseEntity<BookSeats> createBookingSeat(@RequestBody BookSeats bookSeats){

        BookSeats bookSeats1= bookSeatService.createSeat(bookSeats);
        return new ResponseEntity<>(bookSeats1, HttpStatus.CREATED);
    }
}
