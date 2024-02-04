package com.BookMyShow_User.jwtConfig;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponce {

    private String token;
    private String userName;
}
