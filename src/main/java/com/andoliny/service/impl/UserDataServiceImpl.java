package com.andoliny.service.impl;

import com.andoliny.model.entities.UserData;
import com.andoliny.repository.UserDataRepository;
import com.andoliny.service.interfaces.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userDataService")
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public UserData save(UserData userData) {
        return userDataRepository.save(userData);
    }

    @Override
    public void delete(UserData userData) {
        userDataRepository.delete(userData);
    }

    @Override
    public List<UserData> getAll() {
        return userDataRepository.findAll();
    }

    @Override
    public UserData findOne(int id) {
        return userDataRepository.findOne(id);
    }

    @Override
    public void deleteAll() {
        userDataRepository.deleteAll();
    }
}
