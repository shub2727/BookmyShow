package com.example.BookByShow_Ticket.Dto;

import com.example.BookByShow_Ticket.Entity.Booking;
import lombok.Data;


@Data
public class TicketDto {

    private String TicketId;

    private String bookingId;


    private Booking booking;
}
