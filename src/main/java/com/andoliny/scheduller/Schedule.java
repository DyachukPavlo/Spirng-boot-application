package com.andoliny.scheduller;

import com.andoliny.model.entities.Journal;
import com.andoliny.model.entities.User;
import com.andoliny.service.interfaces.JournalService;
import com.andoliny.service.interfaces.UserDataService;
import com.andoliny.service.interfaces.UserService;
import com.andoliny.utils.Averenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@EnableScheduling
public class Schedule {

    @Autowired
    private UserService userService;

    @Autowired
    private JournalService journalService;

    @Autowired
    UserDataService userDataService;

    private Journal journal;


    public Schedule() {
    }

    @Scheduled(fixedRate = 60000)
    public synchronized void makeStatistic() {
        LocalDateTime obsolete = LocalDateTime.of(LocalDate.now(), LocalTime.now().minusSeconds(120));

        LocalDateTime currdate = LocalDateTime.of(LocalDate.now(), LocalTime.now().minusSeconds(60));

        journal = new Journal();
        List<User> users = userService.findNewByDate(currdate);
        if(users.size()>0){
            journal.setAverAge(Averenger.getAverAge(users));
            journal.setSexCount(Averenger.getProp(users, p->p.getUserData().getSex().getDescription()));
            journal.setUserCount(users.size());
            journal.setNationCount(Averenger.getProp(users, p->p.getUserData().getNationality().getName()));
            System.out.println(journal.getNationCount());
            journal.setCreateDate(currdate);
            journalService.save(journal);
        }
        userService.findOldByDate(obsolete).forEach(user -> userService.delete(user));
    }
}
