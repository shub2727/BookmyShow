package com.example.BookMyShow_Booking.Service;

import com.example.BookMyShow_Booking.Dto.BookingDto;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface BookingService {


    public BookingDto createBooking(BookingDto bookingDto);
    public List<BookingDto> getAll();

    public List<BookingDto> getByUserId(String userId);

    public BookingDto getById(String bookingDto);

    public void generateExcel(HttpServletResponse response) throws IOException;

    public void generatePdf(HttpServletResponse response,String bookingId) throws IOException;

}
