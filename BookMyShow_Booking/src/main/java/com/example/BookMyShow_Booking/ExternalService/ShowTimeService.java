package com.example.BookMyShow_Booking.ExternalService;

import com.example.BookMyShow_Booking.Dto.ShowTime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "SHOWTIE-SERVICE")
public interface ShowTimeService {


    @GetMapping("/api/search/{keyword}")
    public List<ShowTime> getShowTime(@PathVariable String keyword);

}
