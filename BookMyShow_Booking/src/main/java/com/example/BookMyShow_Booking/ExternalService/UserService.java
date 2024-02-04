package com.example.BookMyShow_Booking.ExternalService;


import com.example.BookMyShow_Booking.Dto.User;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "USER-SERVICE")
public interface UserService {

    @GetMapping("/api/users/{id}")
    public User getuser(@PathVariable String id);

}
