package com.BookMyShow_User.Service;

import com.BookMyShow_User.Dto.UserDto;
import com.BookMyShow_User.UserEntity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public UserDto createNewUser(UserDto user);

    List<UserDto> getAllUser();

    UserDto getUserById(String id);

    UserDto updateUser(UserDto userDto, String id);

    public UserDto updateSpecificField(String userId, Map<String, Object> fields);


}
