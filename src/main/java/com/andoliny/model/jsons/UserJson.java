package com.andoliny.model.jsons;

import com.andoliny.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserJson {
    private int id;
    private String uuid;
    private String login;
    private String password;
    private String nationality;
    private String  sex;
    private String createDate;

    public UserJson() {
    }

    public UserJson(User user) {
        this.id = user.getId();
        this.uuid = user.getUuid().toString();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.nationality = user.getUserData().getNationality().getName();
        this.sex = user.getUserData().getSex().getDescription();
        this.createDate = user.getCreationDate().toString().replace("T", " ").substring(0,16);
    }


    public static List<UserJson> createOrderJsonList(List<User> users){
        List<UserJson> userJsons = new ArrayList<>();
        if(users != null){
            for(User user: users){
                userJsons.add(new UserJson(user));
            }
        }

        return userJsons;
    }

    @Override
    public String toString() {
        return "UserJson{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nationality='" + nationality + '\'' +
                ", sex='" + sex + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


}

