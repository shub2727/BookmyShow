package com.example.BookByShow_Ticket.Service.Impl;


import com.example.BookByShow_Ticket.ApiConstant.Constants;
import com.example.BookByShow_Ticket.Dto.TicketDto;
import com.example.BookByShow_Ticket.Entity.Booking;
import com.example.BookByShow_Ticket.Entity.Ticket;
import com.example.BookByShow_Ticket.ExternalService.BookingService;
import com.example.BookByShow_Ticket.Repository.TicketRepository;
import com.example.BookByShow_Ticket.Service.TicketSrvice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketServiceImpl  implements TicketSrvice {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    BookingService bookingService;

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {

        String id= UUID.randomUUID().toString();
        ticketDto.setTicketId(id);
        Ticket ticket= new Ticket();
        BeanUtils.copyProperties(ticketDto,ticket);

        Booking booking= bookingService.getBookingId(ticketDto.getBookingId()).getBody();


        ticketDto.setBooking(booking);
        ticketRepository.save(ticket);
        return ticketDto;
    }
}
