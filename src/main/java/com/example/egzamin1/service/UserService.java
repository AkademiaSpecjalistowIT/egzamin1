package com.example.egzamin1.service;

import com.example.egzamin1.entity.UserEntity;
import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findUserByName(String name);

    UserEntity createUser(String userName);
}
