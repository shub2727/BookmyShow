package com.BookMyshow_Movies.ApiConstant;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiRespones {
    private String id;
    private String name;
    private String userName;
    private String email;
    private LocalDate dob;
    private String msg;


}
