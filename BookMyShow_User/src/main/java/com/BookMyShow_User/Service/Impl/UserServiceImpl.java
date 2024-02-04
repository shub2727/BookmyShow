package com.BookMyShow_User.Service.Impl;

import com.BookMyShow_User.Dto.UserDto;
import com.BookMyShow_User.Exception.ResourceNotFoundException;
import com.BookMyShow_User.Repository.UserRepository;
import com.BookMyShow_User.Service.UserService;
import com.BookMyShow_User.UserEntity.User;
import com.BookMyShow_User.Util.EmailUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailUtil emailUtil;


    @Override
    public UserDto createNewUser(UserDto user) {
         String userId = UUID.randomUUID().toString();
         user.setUserID(userId);
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         User user1= new User();
          BeanUtils.copyProperties(user,user1);
          userRepository.save(user1);

          String sub= "you have register successfully";
          String body= emailUtil.readRegEmailBody(user.getName());
          emailUtil.sendEmail(user.getEmail(),sub,body);

          return user;

    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> user= userRepository.findAll();

        List<UserDto> userDtos= new ArrayList<>();

        List<User> userDtoList = user.stream().map(x -> {
            UserDto userDto2 = new UserDto();
            BeanUtils.copyProperties(x, userDto2);
            userDtos.add(userDto2);
            return x;
        }).collect(Collectors.toList());


        return userDtos;
    }

    @Override
    public UserDto getUserById(String id) {

        User user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));

        UserDto userDto= new UserDto();

        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String id) {

        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));

        user.setUserName(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setName(userDto.getName());
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());

        userRepository.save(user);

        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public UserDto updateSpecificField(String userId, Map<String, Object> fields) {

        User user = this.userRepository.findById (userId)
                .orElseThrow (() -> new ResourceNotFoundException ("User", "uId", userId));
        fields.forEach ((key, value) -> {
            Field field = ReflectionUtils.findField (User.class,key);
            Optional<Field> optionalField = Optional.ofNullable (field);
            if (optionalField.isPresent ()) {
                field.setAccessible (true);
                ReflectionUtils.setField (field, user, value);
            } else {
                // Handle the case where the field is not found.
                // You may want to log a warning or throw an exception.
                System.err.println ("Field not found: " + key);
            }
        });
        User savedUser = userRepository.save (user);
        UserDto userDto = new UserDto ();
        BeanUtils.copyProperties (savedUser, userDto);
        return userDto;
    }


}
