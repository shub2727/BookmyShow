package com.example.BookByShow_Ticket.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {


    private String userID;
    private String name;
    private String userName;
    private String email;
    private LocalDate dob;
    private String password;

}
