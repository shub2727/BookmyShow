package com.BookMyShow_User.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {


    private String userID;


    @NotEmpty(message = "User Name should not be empty")
    @Size(max = 30)
    private String name;

    @NotEmpty(message = "User Name  should not be empty")
    @Size(min=5, max = 30)
    private String userName;

    @NotEmpty
    @Email(regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$",
            message = "Email should be in the format abc@gmail.com")
    private String email;


    @NotNull(message = "date of birth must not be null")
    private LocalDate dob;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and include at least " +
                    "one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;

}
