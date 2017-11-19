package com.andoliny.service.interfaces;

import com.andoliny.model.entities.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface UserService extends DataService<User> {
    List<User> findNewByDate(LocalDateTime date);
    List<User> findOldByDate(LocalDateTime date);

}
