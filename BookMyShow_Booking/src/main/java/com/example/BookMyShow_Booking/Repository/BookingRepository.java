package com.example.BookMyShow_Booking.Repository;

import com.example.BookMyShow_Booking.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface BookingRepository extends JpaRepository<Booking,String> {



//    @Query("SELECT b.seats FROM Booking b")
//    public List<String> findAllSeats();
//
//    @Query("SELECT b.seats FROM Booking b WHERE b.showTimeId = :showTimeId")
//    public List<String> findSeatsByShowTimeId(@Param("showTimeId") String showTimeId);
//
//    @Query("SELECT b.seats FROM Booking b WHERE b.showTimeId = :showTimeId AND b.theaterId = :theaterId")
//    public List<String> findSeatsByShowTimeAndTheater(
//            @Param("showTimeId") String showTimeId,
//            @Param("theaterId") String theaterId );

    @Query("SELECT b.seats FROM Booking b WHERE b.showTimeId = :showTimeId AND b.theaterId = :theaterId AND b.movieId = :movieId")
    public List<String> findSeatsByShowTimeTheaterAndMovie(
            @Param("showTimeId") String showTimeId,
            @Param("theaterId") String theaterId,
            @Param("movieId") String movieId
    );

    public List<Booking> findByUserId(String id);






}
