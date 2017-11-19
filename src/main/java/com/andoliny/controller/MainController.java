package com.andoliny.controller;

import com.andoliny.model.entities.*;
import com.andoliny.model.jsons.JournalJson;
import com.andoliny.model.jsons.UserJson;
import com.andoliny.service.interfaces.*;
import com.andoliny.utils.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private SexService sexService;

    @Autowired
    private JournalService journalService;

    @Autowired
    private CountryService countryService;

    private static boolean isCreated;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserJson> getUsers() {
        List<User> users = userService.getAll();
        List<UserJson> userJsons = UserJson.createOrderJsonList(users);
        return userJsons;
    }

    @RequestMapping(value = "/getstatistic", method = RequestMethod.GET)
    @ResponseBody
    public List<JournalJson> getStatistic() {
        List<Journal> journalData = journalService.getAll();
        return JournalJson.createJournalJsonList(journalData);
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser() {

        String uuid = "-1";
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        UserData userData = new UserData();
        userData.setName(Randomizer.genString());
        userData.setNationality(countryService.findOne(Randomizer.genInt(1, 6)));
        userData.setSex(sexService.findOne(Randomizer.genInt(1, 2)));
        userData.setSurname(Randomizer.genString());
        userData.setAge(Randomizer.genInt(10, 100));

        User user = new User();
        user.setLogin(Randomizer.genString());
        user.setPassword(Randomizer.genString());
        user.setUserData(userData);
        user.setCreationDate(today);
        try {
            userService.save(user);
            uuid = user.getUuid().toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return uuid;
    }
    @PostConstruct
    public void postConstruct() {
        if(!isCreated){
            List<Sex> sexes = sexService.getAll();
            List<Country> countries = countryService.getAll();
            if(!(sexes.size()>0)){
                sexService.save(new Sex("Men"));
                sexService.save(new Sex("Women"));
            }
            if(!(countries.size()>0)){
                countryService.save(new Country("Ukraine"));
                countryService.save(new Country("USA"));
                countryService.save(new Country("Spain"));
                countryService.save(new Country("Italy"));
                countryService.save(new Country("Uganda"));
                countryService.save(new Country("Poland"));
            }
            isCreated = true;
        }
    }
}
