package com.andoliny.service.impl;

import com.andoliny.model.entities.Journal;
import com.andoliny.repository.JournalRepository;
import com.andoliny.service.interfaces.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal save(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public void delete(Journal journal) {
        journalRepository.delete(journal);
    }

    @Override
    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    @Override
    public Journal findOne(int id) {
        return journalRepository.findOne(id);
    }

    @Override
    public void deleteAll() {
        journalRepository.deleteAll();
    }
}
