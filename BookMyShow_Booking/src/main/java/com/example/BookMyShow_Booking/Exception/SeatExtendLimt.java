package com.example.BookMyShow_Booking.Exception;

public class SeatExtendLimt extends RuntimeException{

  public   SeatExtendLimt(){
      super("You can book only max 4 seats");
  }
}
