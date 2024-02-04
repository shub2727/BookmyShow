package com.example.BookMyShow_Showtime.Controller;

import com.example.BookMyShow_Showtime.ApiConstant.ApiResponce;
import com.example.BookMyShow_Showtime.Dto.ShowTimeDto;
import com.example.BookMyShow_Showtime.Service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShowTimeController {

    @Autowired
    ShowTimeService showTimeService;
    @PostMapping("/api/")

    public ResponseEntity<ShowTimeDto> creeateShow(@RequestBody ShowTimeDto showTimeDto){
        ShowTimeDto showTimeDto1= showTimeService.create(showTimeDto);
        return new ResponseEntity<>(showTimeDto1, HttpStatus.CREATED);
    }

    @GetMapping("/api/")
    public ResponseEntity<List<ShowTimeDto>> getAllmovies(){


        List<ShowTimeDto> showTimeDtos= showTimeService.getAll();

        return new ResponseEntity<>(showTimeDtos,HttpStatus.CREATED);

    }


    @GetMapping("/api/search/{keyword}")
    ResponseEntity<List<ShowTimeDto>> getShowByTime(@PathVariable String keyword){
        List<ShowTimeDto> showTimeDto= showTimeService.getByTime(keyword);
        return  new ResponseEntity<>(showTimeDto,HttpStatus.CREATED);

    }

    @GetMapping("/api/{keyword}")
    ResponseEntity<ShowTimeDto> getShowById(@PathVariable String keyword){
        ShowTimeDto showTimeDto= showTimeService.getById(keyword);
        return  new ResponseEntity<>(showTimeDto,HttpStatus.CREATED);

    }


}
