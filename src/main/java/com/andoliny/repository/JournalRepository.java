package com.andoliny.repository;

import com.andoliny.model.entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface JournalRepository extends JpaRepository<Journal, Integer> {
}
