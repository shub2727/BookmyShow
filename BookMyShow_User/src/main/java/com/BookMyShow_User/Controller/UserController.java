package com.BookMyShow_User.Controller;


import com.BookMyShow_User.ApiConstant.ApiRespones;
import com.BookMyShow_User.Dto.UserDto;
import com.BookMyShow_User.Service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<ApiRespones> RegistorUser(@Valid @RequestBody UserDto userDto){

        UserDto userDto1= userService.createNewUser(userDto);

        ApiRespones respones= ApiRespones.builder()
                .id(userDto1.getUserID())
                .name(userDto1.getName())
                .email(userDto1.getEmail())
                .dob(userDto1.getDob())
                .userName(userDto.getUserName())
                .build();

        return new ResponseEntity<>(respones, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos= userService.getAllUser();
        return new ResponseEntity<>(userDtos,HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserbyId(@PathVariable ("id") String id){
        UserDto userDtos= userService.getUserById(id);
        return new ResponseEntity<>(userDtos,HttpStatus.CREATED);

    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<ApiRespones> UpdateUser(@PathVariable String id,   @Valid @RequestBody UserDto userDto){

        UserDto userDto1= userService.updateUser(userDto,id);

        ApiRespones respones= ApiRespones.builder()
                .id(userDto1.getUserID())
                .name(userDto1.getName())
                .email(userDto1.getEmail())
                .dob(userDto1.getDob())
                .userName(userDto.getUserName())
                .build();

        return new ResponseEntity<>(respones, HttpStatus.CREATED);

    }

    @PatchMapping(value = "/{userId}",
            consumes = {"multipart/form-data","application/json","application/xml"})
    public ResponseEntity<UserDto> updateSpecificField(@PathVariable ("userId") String uId,@RequestBody Map<String,Object> objectMap){
        System.out.println (objectMap.isEmpty ());
        UserDto updatedUserDto = this.userService.updateSpecificField(uId,objectMap );
        return ResponseEntity.ok(updatedUserDto);
    }


}
