package com.BookMyshow_Movies.Dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MoviesDto {

    private String movieId;
    @NotEmpty(message = "Movie name should not be empty")
    private String name;

    private LocalDate releaseDate;
    @NotEmpty(message = "Movie name should not be empty")
    private String category;
    private List<String> language;
    private List<String> genre;
    private String rating;

    private String poster;

}
