package com.example.BookByShow_Payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookByShowPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookByShowPaymentApplication.class, args);
	}

}
