package com.example.BookByShow_Payment.Service.Impl;

import com.example.BookByShow_Payment.Dto.Booking;
import com.example.BookByShow_Payment.Dto.PaymentDto;
import com.example.BookByShow_Payment.Entity.Payment;
import com.example.BookByShow_Payment.Exception.ResourceNotFoundException;
import com.example.BookByShow_Payment.ExternalService.BookingService;
import com.example.BookByShow_Payment.Repository.PaymentRepo;
import com.example.BookByShow_Payment.Service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    BookingService bookingService;


    @Override
    public PaymentDto createPayment(PaymentDto  paymentDto) {



        LocalDateTime lockExpirationTime = LocalDateTime.now();

        String id= UUID.randomUUID().toString();
        paymentDto.setPaymentID(id);


        Payment payment= new Payment();

        BeanUtils.copyProperties(paymentDto,payment);

        paymentRepo.save(payment);
        return paymentDto;
    }
}
