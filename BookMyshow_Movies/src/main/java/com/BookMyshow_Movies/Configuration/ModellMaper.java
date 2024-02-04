package com.BookMyshow_Movies.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModellMaper {

    @Bean
    public org.modelmapper.ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
