package com.andoliny.service.impl;

import com.andoliny.model.entities.Country;
import com.andoliny.repository.CountryRepository;
import com.andoliny.service.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findOne(int id) {
        return countryRepository.findOne(id);
    }

    @Override
    public void deleteAll() {
        countryRepository.deleteAll();
    }
}
