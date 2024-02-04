package com.example.BookMyShow_Showtime.Repository;

import com.example.BookMyShow_Showtime.Entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowTimeRepository extends JpaRepository<ShowTime,String> {

    List<ShowTime> findByStartTimeContaining(String name);
}
