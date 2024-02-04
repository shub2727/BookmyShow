package com.example.BookByShow_Ticket.Repository;

import com.example.BookByShow_Ticket.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
