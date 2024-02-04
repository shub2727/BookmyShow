package com.BookMyshow_Movies.Service.MoviesImpl;

import com.BookMyshow_Movies.Dto.MoviesDto;
import com.BookMyshow_Movies.Entity.Movies;
import com.BookMyshow_Movies.Exception.ResourceNotFoundException;
import com.BookMyshow_Movies.Repository.MoviesRepository;
import com.BookMyshow_Movies.Service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MoviesServiceImpl  implements MovieService {

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public MoviesDto create(MoviesDto moviesDto) {

        Movies movies=new Movies();
        String userId = UUID.randomUUID().toString();
        moviesDto.setMovieId(userId);
        modelMapper.map(moviesDto,movies);
        moviesRepository.save(movies);
        return moviesDto;
    }

    @Override
    public List<List<MoviesDto>> search(String keyWord) {

        List<Movies> moviesNames= moviesRepository.findByNameContaining(keyWord);

        List<Movies> moviescat=moviesRepository.findByCategoryContaining(keyWord);

        List<Movies> moviesByLanguage = moviesRepository.findByLanguage(keyWord);

       // List<Movies> lang=moviesRepository.findByLanguageIn(Collections.singletonList(keyWord));



        List<MoviesDto> moviesDtosName= moviesNames.stream().map(movies -> this.modelMapper.map(movies,MoviesDto.class)).collect(Collectors.toList());
        List<MoviesDto> moviesDtocat= moviescat.stream().map(movies -> this.modelMapper.map(movies,MoviesDto.class)).collect(Collectors.toList());

        List<MoviesDto> moviesDtolang= moviesByLanguage.stream().map(movies -> this.modelMapper.map(movies,MoviesDto.class)).collect(Collectors.toList());

        List<List<MoviesDto>> allSearch= Arrays.asList(moviesDtosName,moviesDtocat,moviesDtolang);


        return allSearch;
    }

    @Override
    public List<MoviesDto> getAll() {
        List<Movies> user= moviesRepository.findAll();

        List<MoviesDto> moviesDtos= new ArrayList<>();

        List<Movies> userDtoList = user.stream().map(x -> {
            MoviesDto moviesDto = new MoviesDto();
            BeanUtils.copyProperties(x, moviesDto);
            moviesDtos.add(moviesDto);
            return x;
        }).collect(Collectors.toList());
        return moviesDtos;

    }

    @Override
    public MoviesDto getMovieById(String id) {
        Movies  theater= moviesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
        MoviesDto moviesDto= new MoviesDto();
        BeanUtils.copyProperties(theater,moviesDto);
        return moviesDto;

    }


    @Override
    public boolean DelMovie(String id) {
        return false;
    }

}
