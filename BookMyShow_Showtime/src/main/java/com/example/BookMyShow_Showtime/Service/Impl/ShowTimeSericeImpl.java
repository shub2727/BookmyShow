package com.example.BookMyShow_Showtime.Service.Impl;

import com.example.BookMyShow_Showtime.Dto.ShowTimeDto;
import com.example.BookMyShow_Showtime.Entity.Movies;
import com.example.BookMyShow_Showtime.Entity.ShowTime;
import com.example.BookMyShow_Showtime.Entity.Theaters;
import com.example.BookMyShow_Showtime.Exception.ResourceNotFoundException;
import com.example.BookMyShow_Showtime.ExternalService.MoviesService;
import com.example.BookMyShow_Showtime.ExternalService.TheaterService;
import com.example.BookMyShow_Showtime.Repository.ShowTimeRepository;
import com.example.BookMyShow_Showtime.Service.ShowTimeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ShowTimeSericeImpl implements ShowTimeService {

    @Autowired
    ShowTimeRepository showTimeRepository;

    @Autowired
    TheaterService theaterService;
    @Autowired
    MoviesService moviesService;

    @Autowired
    ModelMapper modelMapper;

    private List<String> convertObjectToJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(object);
            List<String> list = new ArrayList<>();
            list.add(jsonString);
            return list;
        } catch (JsonProcessingException e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public ShowTimeDto create(ShowTimeDto showTimeDto) {

        ShowTime showTime = new ShowTime();
        String idd = UUID.randomUUID().toString();
        showTimeDto.setShowtimeID(idd);

        List<String> movieString= showTimeDto.getMovieIdList();

       List<Movies> moviesList = movieString.stream().map((mov) -> {
            Movies movies = moviesService.getMovie(mov);
            return movies;
        }).collect(Collectors.toList());

       showTimeDto.setMoviesList(moviesList);

        List<String> theralist= showTimeDto.getThetarIdList();

        List<Theaters> theatersList = theralist.stream().map((the) -> {
            Theaters theaters = theaterService.getThaera(the);
            return theaters;
        }).collect(Collectors.toList());

        showTimeDto.setTheatersList(theatersList);

        modelMapper.map(showTimeDto, showTime);
        showTimeRepository.save(showTime);

        return showTimeDto;
    }

//
//    @Override
//    public ShowTimeDto create(ShowTimeDto showTimeDto) {
//
//        ShowTime showTime = new ShowTime();
//        String idd = UUID.randomUUID().toString();
//        showTimeDto.setShowtimeID(idd);
//
//
//        List<Movies> moviesList= moviesService.getMovie(showTimeDto.getMovieId())
//
//        List<Movies> moviesList = showTimeDto.getMoviesList();
//
//        List<Movies> moviesList2 = new ArrayList<>();
//
//        List<Movies> moviesList1 = moviesList.stream().map((movies) -> {
//            Movies movies1 = moviesService.getMovie(movies.getMovieId());
//            List<Theaters> theaterlistt = movies.getTheatersList().stream().map((th) -> {
//                Theaters theaters = theaterService.getThaera(th.getTheaterId());
//                return theaters;
//            }).collect(Collectors.toList());
//            movies1.setTheatersList(theaterlistt);
//            moviesList2.add(movies1);
//            return movies1;
//        }).collect(Collectors.toList());
//
//        moviesList2.stream().forEach(a -> System.out.println(a.getName()));
//
//        showTimeDto.setMoviesList(moviesList1);
//        modelMapper.map(showTimeDto, showTime);
//        moviesList2.stream().map((x) -> {
//            showTime.setMoviesJson(convertObjectToJsonString(x));
//            return x;
//        }).collect(Collectors.toList());
//
//        showTimeRepository.save(showTime);
//        return showTimeDto;
//    }
    @Override
    public List<ShowTimeDto> getAll() {

        List<ShowTime> showTimeList = showTimeRepository.findAll();

        System.out.println(showTimeList.size());

        List<ShowTimeDto> showTimeDtos = new ArrayList<>();

        List<ShowTime> s = showTimeList.stream().map((x) -> {
             List<String> movieIdList = x.getMovieIdList();
            System.out.println(movieIdList.size());
            List<Movies> moviesLists = movieIdList.stream().map((mov) -> {
                System.out.println("********************************");
                Movies movies = moviesService.getMovie(mov);
                System.out.println(movies.getName()+"********************************");
                return movies;
            }).collect(Collectors.toList());

            List<Theaters> theatersList = x.getThetarIdList().stream().map((the) -> {
                Theaters theaters = theaterService.getThaera(the);
                return theaters;
            }).collect(Collectors.toList());


             ShowTimeDto showTimeDto = new ShowTimeDto();
            BeanUtils.copyProperties(x, showTimeDto);

            showTimeDto.setMoviesList(moviesLists);
            showTimeDto.setTheatersList(theatersList);
            showTimeDtos.add(showTimeDto);

            return x;

        }).collect(Collectors.toList());

        return showTimeDtos;
    }

    @Override
    public  List<ShowTimeDto> getByTime(String time) {

        List<ShowTime> showTimeList= showTimeRepository.findByStartTimeContaining(time);
        System.out.println(showTimeList.size());

        List<ShowTimeDto> showTimeDtos = new ArrayList<>();

        List<ShowTime> s = showTimeList.stream().map((x) -> {
            List<String> movieIdList = x.getMovieIdList();
            System.out.println(movieIdList.size());
            List<Movies> moviesLists = movieIdList.stream().map((mov) -> {
               Movies movies = moviesService.getMovie(mov);
                return movies;
            }).collect(Collectors.toList());

            List<Theaters> theatersList = x.getThetarIdList().stream().map((the) -> {
                Theaters theaters = theaterService.getThaera(the);
                return theaters;
            }).collect(Collectors.toList());


            ShowTimeDto showTimeDto = new ShowTimeDto();
            BeanUtils.copyProperties(x, showTimeDto);

            showTimeDto.setMoviesList(moviesLists);
            showTimeDto.setTheatersList(theatersList);
            showTimeDtos.add(showTimeDto);

            return x;

        }).collect(Collectors.toList());


     // List<ShowTimeDto> moviesDtosName= showTimeList.stream().map(show -> this.modelMapper.map(show,ShowTimeDto.class)).collect(Collectors.toList());


//        List<ShowTimeDto> showTimeDtos = new ArrayList<>();
//
//        List<ShowTime> s = showTimeList.stream().map(x -> {
//            ShowTimeDto showTimeDto = new ShowTimeDto();
//            BeanUtils.copyProperties(x, showTimeDto);
//            showTimeDtos.add(showTimeDto);
//            return x;
//        }).collect(Collectors.toList());

        return showTimeDtos;



    }


    @Override
    public ShowTimeDto getById(String time) {
        ShowTime showTime=  showTimeRepository.findById(time).orElseThrow(()->new ResourceNotFoundException("user","id",time));
        ShowTimeDto showTimeDto= new ShowTimeDto();


        List<Movies> moviesLists = showTime.getMovieIdList().stream().map((mov) -> {

            Movies movies = moviesService.getMovie(mov);

            return movies;
        }).collect(Collectors.toList());

        List<Theaters> theatersList = showTime.getThetarIdList().stream().map((the) -> {
            Theaters theaters = theaterService.getThaera(the);
            return theaters;
        }).collect(Collectors.toList());

        BeanUtils.copyProperties(showTime, showTimeDto);

        showTimeDto.setMoviesList(moviesLists);
        showTimeDto.setTheatersList(theatersList);
        return showTimeDto;
    }

    @Override
    public String delShow(String time) {
        return null;
    }
}
