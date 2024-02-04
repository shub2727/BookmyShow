package com.example.BookMyShow_Showtime.ApiConstant;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data

public class ApiResponce {


    private String showtimeID;
    private String startTime;
    private String endTime;
    private List<String> moviesJson;



}
