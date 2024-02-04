package com.example.BookMyShow_Theater.Controller;

import com.example.BookMyShow_Theater.Dto.TheaterDto;
import com.example.BookMyShow_Theater.Srevice.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/")
    ResponseEntity<TheaterDto> createTheater(@RequestBody TheaterDto theaterDto){
        TheaterDto theaterDto1= theaterService.createTheater(theaterDto);
        return new ResponseEntity<>(theaterDto1, HttpStatus.CREATED);

    }

    @GetMapping("/")
    ResponseEntity<List<TheaterDto>> getAllTheater(){
        List<TheaterDto> theaterDtoList= theaterService.getAll();
        return  new ResponseEntity<>(theaterDtoList,HttpStatus.CREATED);

     }

    @GetMapping("/{id}")
    ResponseEntity<TheaterDto> getTheaterById(@PathVariable String id){
        TheaterDto theaterDtoList= theaterService.getByID(id);
        return  new ResponseEntity<>(theaterDtoList,HttpStatus.CREATED);

    }

     @PutMapping("/update/{id}")
    ResponseEntity<TheaterDto> updateTheater(@RequestBody TheaterDto theaterDto, @PathVariable String id){

        TheaterDto theaterDto1= theaterService.updateTheater(theaterDto,id);
        return new ResponseEntity<>(theaterDto1,HttpStatus.CREATED);

     }

     @DeleteMapping("/{id}")
    ResponseEntity<String> delTheater(@PathVariable String id){
        String theater = theaterService.deleteTheater(id);

        return new ResponseEntity<>(theater,HttpStatus.CREATED);
     }

}
