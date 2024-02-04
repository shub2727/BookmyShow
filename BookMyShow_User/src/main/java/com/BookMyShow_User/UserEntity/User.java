package com.BookMyShow_User.UserEntity;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints ={ @UniqueConstraint(columnNames = "email"),
                          @UniqueConstraint(columnNames = "userName")})


public class User {

    @Id
    private String userID;
    private String name;
    private String userName;
    private String email;
    private LocalDate dob;
    private String password;

}
