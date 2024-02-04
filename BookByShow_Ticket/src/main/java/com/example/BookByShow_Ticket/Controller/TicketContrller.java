package com.example.BookByShow_Ticket.Controller;


import com.example.BookByShow_Ticket.Dto.TicketDto;
import com.example.BookByShow_Ticket.Service.TicketSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketContrller {



    @Autowired
    TicketSrvice ticketSrvice;

    @PostMapping("/api/ticket")
    ResponseEntity<TicketDto> createTickets(@RequestBody TicketDto ticketDto){

        TicketDto ticketDto1= ticketSrvice.createTicket(ticketDto);


        return new ResponseEntity<>(ticketDto1, HttpStatus.CREATED);
    }
}
