package com.example.BookMyShow_Booking.Repository;

import com.example.BookMyShow_Booking.Entity.BookSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SeatskRepository extends JpaRepository<BookSeats, String> {


    @Query("SELECT b.seat FROM BookSeats b WHERE b.showTimeId = :showTimeId AND b.theaterId = :theaterId AND b.movieId = :movieId")
    public List<String> findSeatsByShowTimeTheaterAndMovie(
            @Param("showTimeId") String showTimeId,
            @Param("theaterId") String theaterId,
            @Param("movieId") String movieId
    );


    List<BookSeats> findByIsBookedAndLockExpirationTimeLessThan(boolean isBooked, LocalDateTime lockExpirationTime);
}