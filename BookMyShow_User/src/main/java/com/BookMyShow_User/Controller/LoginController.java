package com.BookMyShow_User.Controller;

import com.BookMyShow_User.jwtConfig.JwtHelper;
import com.BookMyShow_User.jwtConfig.JwtResponce;
import com.BookMyShow_User.UserEntity.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

//    @Autowired
//    LoginService loginService;

    @Autowired
    private AuthenticationManager authenticationManager;


//    @PostMapping("/token")
//    public String getToken(@RequestBody Login login) {
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
//        if (authenticate.isAuthenticated()) {
//            return loginService.generateToken(login.getUserName());
//        } else {
//            throw new RuntimeException("invalid access");
//        }
//    }
//
//    @GetMapping("/validate")
//    public String validateToken(@RequestParam("token") String token) {
//        loginService.validateToken(token);
//        return "Token is valid";
//    }


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @PostMapping("/")
    public ResponseEntity<JwtResponce> login(@RequestBody Login request) {

        this.doAuthenticate(request.getUserName(), request.getPassword());


        /*
         If authentication succeeds, it loads the UserDetails for the logged
         in user by calling the UserDetailsService.
         The purpose of this method is that after a user is authenticated (e.g. by validating password),
          the authentication manager can call this method to fetch the UserDetails for that now logged in user.
         */
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());

        String token = this.helper.generateToken(userDetails);

        JwtResponce response = JwtResponce.builder()
                .token(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String name, String password) {

        /*
        When Spring Security authenticates a user, it checks if the UsernamePasswordAuthenticationToken
        provided matches the username and password stored in the system.
         */
        /*
        The authentication manager takes an Authentication object such as
        UsernamePasswordAuthenticationToken containing user credentials
       "returning a fully populated Authentication object (including granted authorities) if successful"
         */

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(name, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
