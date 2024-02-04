package com.example.BookMyShow_Showtime;

import com.example.BookMyShow_Showtime.Entity.Movies;
import com.example.BookMyShow_Showtime.Entity.Theaters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class BookMyShowShowtimeApplication {

	public static void main(String[] args) {
		 SpringApplication.run(BookMyShowShowtimeApplication.class, args);


	}

}
