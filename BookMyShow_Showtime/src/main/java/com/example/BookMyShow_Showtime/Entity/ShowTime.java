package com.example.BookMyShow_Showtime.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class ShowTime  {

    @Id
    private String showtimeID;
    private String startTime;
    private LocalDate showDate;

    private String endTime;
    private List<String> movieIdList;
    private List<String> thetarIdList;


   @Transient
    private List<Movies> moviesList ;
    @Transient
    private List<Theaters> theatersList;
//


}
