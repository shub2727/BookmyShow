package com.example.BookMyShow_Booking.ExternalService;

import com.example.BookMyShow_Booking.Dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentService {



    @PostMapping("/api/payment")
    PaymentDto craete(@RequestBody PaymentDto paymentDto);


}
