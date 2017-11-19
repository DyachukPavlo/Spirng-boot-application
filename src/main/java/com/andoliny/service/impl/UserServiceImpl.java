package com.andoliny.service.impl;

import com.andoliny.model.entities.User;
import com.andoliny.repository.UserRepository;
import com.andoliny.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> findNewByDate(LocalDateTime date) {
        return userRepository.findNewByDate(date);
    }

    @Override
    public List<User> findOldByDate(LocalDateTime date) {
        return userRepository.findOldByDate(date);
    }
}
