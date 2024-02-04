package com.example.BookByShow_Payment.Controlletr;

import com.example.BookByShow_Payment.Dto.PaymentDto;
import com.example.BookByShow_Payment.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping("/api/payment")
    ResponseEntity<PaymentDto> craete(@RequestBody PaymentDto paymentDto){
        PaymentDto paymentDto1= paymentService.createPayment( paymentDto);
        return new ResponseEntity<>(paymentDto1, HttpStatus.CREATED);
        }
}
