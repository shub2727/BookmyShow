package com.example.BookMyShow_Booking.Service.Impl;


import com.example.BookMyShow_Booking.Entity.BookSeats;
import com.example.BookMyShow_Booking.Exception.ResourceNotFoundException;
import com.example.BookMyShow_Booking.Repository.SeatskRepository;
import com.example.BookMyShow_Booking.Service.BookSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookSeatImpl implements BookSeatService {


    private static final long LOCK_DURATION_SECONDS = 30;
    @Autowired
    SeatskRepository seatskRepository;



    @Override
    public BookSeats createSeat(BookSeats bookingDto) {

        String id = UUID.randomUUID().toString();
        List<String> s3 = seatskRepository.findSeatsByShowTimeTheaterAndMovie(bookingDto.getShowTimeId(),
                bookingDto.getTheaterId(), bookingDto.getMovieId());

        List<String> separatedList = new ArrayList<>();
        for (String input : s3) {

            String[] elements = input.split(",\\s*"); // Use regex to handle optional spaces after comma
            for (String element : elements) {
                if (!element.isEmpty()) {
                    separatedList.add(element);
                }
            }
        }

        List<String> avlSeat = new ArrayList<>();
        bookingDto.getSeat().stream().map((seat) -> {
            List<String> ckeckSeat = separatedList.stream().map((check) -> {

                if (seat.equals(check)) {
                    throw new ResourceNotFoundException("Seat already booked", "id", check);
                } else {
                    return check;
                }
            }).collect(Collectors.toList());
            avlSeat.add(ckeckSeat.toString());
            return seat;
        }).collect(Collectors.toList());


        LocalDateTime lockExpirationTime = LocalDateTime.now().plusSeconds(LOCK_DURATION_SECONDS);

        bookingDto.getSeat().forEach(seat -> {
            BookSeats seatLock = new BookSeats();
            seatLock.setId(id);
            seatLock.setMovieId(bookingDto.getMovieId());
            seatLock.setTheaterId(bookingDto.getTheaterId());
            seatLock.setShowTimeId(bookingDto.getShowTimeId());
            seatLock.setSeat(bookingDto.getSeat());
            seatLock.setBooked(true);
            seatLock.setLockExpirationTime(lockExpirationTime);
            seatLock.setBookingId(bookingDto.getBookingId());
            seatskRepository.save(seatLock);

        });


        return bookingDto;
    }


    public void releaseExpiredSeatLocks() {

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime lockExpirationTime = LocalDateTime.now().minusSeconds(LOCK_DURATION_SECONDS);
        List<BookSeats> expiredBookings = seatskRepository.findByIsBookedAndLockExpirationTimeLessThan(true, lockExpirationTime);

        for (BookSeats booking : expiredBookings) {
            // Log relevant information

            // Release the seat only if the lock expiration time is in the past
            if (booking.getLockExpirationTime() != null && booking.getLockExpirationTime().isBefore(currentDateTime)) {
                booking.setBooked(false);
                booking.setSeat(new ArrayList<>());
                booking.setLockExpirationTime(currentDateTime);
                seatskRepository.save(booking);
            }
        }
    }
}
