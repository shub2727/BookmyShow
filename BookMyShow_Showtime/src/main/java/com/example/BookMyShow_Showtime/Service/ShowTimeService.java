package com.example.BookMyShow_Showtime.Service;

import com.example.BookMyShow_Showtime.Dto.ShowTimeDto;
import com.example.BookMyShow_Showtime.Entity.ShowTime;

import java.util.List;

public interface ShowTimeService {

    public ShowTimeDto create(ShowTimeDto showTimeDto );

    public List<ShowTimeDto> getAll();

    List<ShowTimeDto> getByTime(String time);

    ShowTimeDto getById(String time);

    String delShow(String time);

}
