package com.BookMyshow_Movies.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movies {

    @Id
    private String movieId;
    private String name;
    private LocalDate releaseDate;
    private String category;
    private List<String> genre;
    private String rating;
    private List<String> language;
    private String poster;
}
