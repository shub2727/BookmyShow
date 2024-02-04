package com.example.BookByShow_Payment.Repository;

import com.example.BookByShow_Payment.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {


}
