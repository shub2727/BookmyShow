package com.example.BookByShow_Ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookByShowTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookByShowTicketApplication.class, args);
	}

}
