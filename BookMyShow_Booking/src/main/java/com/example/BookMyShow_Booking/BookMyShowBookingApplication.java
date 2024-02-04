package com.example.BookMyShow_Booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookMyShowBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowBookingApplication.class, args);
	}

}
