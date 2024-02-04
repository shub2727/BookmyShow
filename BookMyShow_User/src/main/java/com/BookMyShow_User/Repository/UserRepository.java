package com.BookMyShow_User.Repository;

import com.BookMyShow_User.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUserName(String name);
    //User findByPassword(String password);
}
