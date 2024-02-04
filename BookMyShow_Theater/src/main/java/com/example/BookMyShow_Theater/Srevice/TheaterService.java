package com.example.BookMyShow_Theater.Srevice;

import com.example.BookMyShow_Theater.Dto.TheaterDto;
import com.example.BookMyShow_Theater.Entity.Theater;

import java.util.List;

public interface TheaterService {

    public TheaterDto createTheater(TheaterDto theaterDto);

    public TheaterDto updateTheater(TheaterDto theaterDto,String id);

    public List<TheaterDto> getAll();

    public TheaterDto getByID(String id);

    public String deleteTheater(String Id);

    public Integer checkAvailability();

}
