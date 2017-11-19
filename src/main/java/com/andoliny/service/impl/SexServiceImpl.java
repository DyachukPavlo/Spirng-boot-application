package com.andoliny.service.impl;

import com.andoliny.model.entities.Sex;
import com.andoliny.repository.SexRepository;
import com.andoliny.service.interfaces.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sexService")
public class SexServiceImpl implements SexService {

    @Autowired
    private SexRepository sexRepository;

    @Override
    public Sex save(Sex sex) {
        return sexRepository.save(sex);
    }

    @Override
    public void delete(Sex sex) {
        sexRepository.delete(sex);
    }

    @Override
    public List<Sex> getAll() {
        return sexRepository.findAll();
    }

    @Override
    public Sex findOne(int id) {
        return sexRepository.findOne(id);
    }

    @Override
    public void deleteAll() {
        sexRepository.deleteAll();
    }
}
