package com.BookMyshow_Movies.Controller;

import com.BookMyshow_Movies.Dto.MoviesDto;
import com.BookMyshow_Movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    MovieService movieService;

    @PostMapping("/")
    ResponseEntity<MoviesDto> createMovie(@RequestBody MoviesDto moviesDto){

        MoviesDto moviesDto1= movieService.create(moviesDto);
        return new ResponseEntity<>(moviesDto1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<MoviesDto>> getAllmovies(){
        List<MoviesDto> userDtos= movieService.getAll();
        return new ResponseEntity<>(userDtos,HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
        public ResponseEntity<MoviesDto> getmovieById(@PathVariable String id){
        MoviesDto userDtos= movieService.getMovieById(id);
        return new ResponseEntity<>(userDtos,HttpStatus.CREATED);

    }
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<List<MoviesDto>>> searchPostByTitil(
            @PathVariable(required = false) String keywords){
        List<List<MoviesDto>> result= this.movieService.search(keywords);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }



}
