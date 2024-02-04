package com.example.BookMyShow_Theater.Repository;

import com.example.BookMyShow_Theater.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater,String> {

    public List<Theater> findByName(String name);
}
