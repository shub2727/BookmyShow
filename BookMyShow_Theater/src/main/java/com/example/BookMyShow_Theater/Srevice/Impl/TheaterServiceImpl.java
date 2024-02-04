package com.example.BookMyShow_Theater.Srevice.Impl;

import com.example.BookMyShow_Theater.Dto.TheaterDto;
import com.example.BookMyShow_Theater.Entity.Theater;
import com.example.BookMyShow_Theater.Exception.ResourceNotFoundException;
import com.example.BookMyShow_Theater.Repository.TheaterRepository;
import com.example.BookMyShow_Theater.Srevice.TheaterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public TheaterDto createTheater(TheaterDto theaterDto) {

        String idd = UUID.randomUUID().toString();
        theaterDto.setTheaterId(idd);
        List<Theater> savedThatre = theaterRepository.findByName(theaterDto.getName());
        savedThatre.stream().forEach((e) -> {
            if (  e.getName().equals(theaterDto.getName()) && e.getLocation().equals(theaterDto.getLocation())) {
                throw new ResourceNotFoundException();
            }
        });
        Theater theater = new Theater();
        BeanUtils.copyProperties(theaterDto, theater);
        theaterRepository.save(theater);

        return theaterDto;
    }

    @Override
    public TheaterDto updateTheater(TheaterDto theaterDto, String id) {
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));

        theater.setTheaterId(id);
        theater.setName(theaterDto.getName());
        theater.setLocation(theaterDto.getLocation());
        theater.setScreens(theaterDto.getScreens());
        theater.setSeatingCapacity(theaterDto.getSeatingCapacity());
        theaterRepository.save(theater);

        return theaterDto;

    }

    @Override
    public List<TheaterDto> getAll() {
        List<Theater> theater = theaterRepository.findAll();
        List<TheaterDto> theaterDto = new ArrayList<>();
        List<Theater> userDtoList = theater.stream().map(x -> {
            TheaterDto theaterDto1 = new TheaterDto();
            BeanUtils.copyProperties(x, theaterDto1);
            theaterDto.add(theaterDto1);
            return x;
        }).collect(Collectors.toList());


        return theaterDto;
    }

    @Override
    public TheaterDto getByID(String id) {

        Theater theater = theaterRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("user", "id", id));
        TheaterDto theaterDto = new TheaterDto();
        BeanUtils.copyProperties(theater, theaterDto);
        return theaterDto;
    }

    @Override
    public String deleteTheater(String Id) {

        Theater theater = theaterRepository.findById(Id).orElseThrow(()
                -> new ResourceNotFoundException("user", "id", Id));
        if (theater.getTheaterId().equals(Id)) {
            theaterRepository.deleteById(Id);
            return "Theater deleted successfully";
        }
        return "Theater not deleted";
    }

    @Override
    public Integer checkAvailability() {
        return null;
    }
}
