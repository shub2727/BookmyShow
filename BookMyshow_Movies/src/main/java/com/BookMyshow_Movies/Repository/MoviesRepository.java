package com.BookMyshow_Movies.Repository;

import com.BookMyshow_Movies.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies,String> {

    List<Movies> findByCategoryContaining(String keyword);

    List<Movies> findByNameContaining(String keyword);
    @Query("SELECT m FROM Movies m WHERE :language IN (m.language)")
    List<Movies> findByLanguage(@Param("language") String language);

//    @Query("SELECT e FROM Movies e WHERE e.language IN :languages")
//    List<Movies> findByLanguage(@Param("languages") String languages);

    List<Movies> findByLanguageIn(List<String> languages);




}
