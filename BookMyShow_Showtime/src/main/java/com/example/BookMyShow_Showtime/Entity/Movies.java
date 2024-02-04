package com.example.BookMyShow_Showtime.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Movies implements Serializable {
    private String movieId;
    private String name;
    private LocalDate releaseDate;
    private String category;
    private List<String> genre;
    private String rating;
    private List<String> language;
    private String poster;



}
