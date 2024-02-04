package com.BookMyShow_User.Service;

import com.BookMyShow_User.ApiConstant.LoginRespone;
import com.BookMyShow_User.UserEntity.Login;

public interface LoginService {

    public LoginRespone userLogin(Login login);

    public String generateToken(String username);

    public void validateToken(String token);
}
