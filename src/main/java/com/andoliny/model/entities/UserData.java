package com.andoliny.model.entities;


import com.andoliny.model.interfaces.DomainObject;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData implements DomainObject {
    private int id;
    private String name;
    private String surname;
    private Sex sex;
    private Country nationality;
    private User user;
    private int age;

    public UserData(String name, String surname, Sex sex, Country nationality, int age, User user) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.nationality = nationality;
        this.user = user;
        this.age = age;
    }

    public UserData() {
    }

    public UserData(String name, Sex sex, Country nationality) {
        this.name = name;
        this.sex = sex;
        this.nationality = nationality;
    }

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))

    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality")
    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userData")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "name", unique = false, nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", unique = false, nullable = true, length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sex")
    public Sex getSex() {
        return this.sex;
    }

    @Column(name = "age", unique = false, nullable = true)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", nationality=" + nationality +
                ", age=" + age +
                '}';
    }

}
