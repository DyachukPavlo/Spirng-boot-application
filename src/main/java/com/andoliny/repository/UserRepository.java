package com.andoliny.repository;

import com.andoliny.model.entities.Journal;
import com.andoliny.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.creationDate >= :date")
    List<User> findNewByDate(@Param("date") LocalDateTime date);

    @Query("select u from User u where u.creationDate < :date")
    List<User> findOldByDate(@Param("date") LocalDateTime date);

}
