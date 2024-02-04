package com.BookMyshow_Movies.Service;

import com.BookMyshow_Movies.Dto.MoviesDto;

import java.util.List;

public interface MovieService {

    public MoviesDto create(MoviesDto moviesDto);

    List<List<MoviesDto>>search(String keyWord);

    List<MoviesDto> getAll();

    MoviesDto getMovieById(String id);

    boolean DelMovie(String id);

}
