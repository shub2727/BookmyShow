package com.example.BookMyShow_Showtime.ExternalService;

import com.example.BookMyShow_Showtime.Entity.Movies;
import com.example.BookMyShow_Showtime.Entity.Theaters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "MOVIES-SERVICE")
public interface MoviesService {
    @GetMapping("/api/movies/{id}")
    public Movies getMovie(@PathVariable String id);
}
