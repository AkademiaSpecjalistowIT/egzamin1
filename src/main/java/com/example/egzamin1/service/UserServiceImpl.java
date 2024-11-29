package com.example.egzamin1.service;

import com.example.egzamin1.entity.UserEntity;
import com.example.egzamin1.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Optional<UserEntity> findUserByName(String name) {
        return userRepository.findUserEntityByName(name);
    }

    @Override
    public UserEntity createUser(String userName) {
        return userRepository.save(new UserEntity(userName));
    }
}
