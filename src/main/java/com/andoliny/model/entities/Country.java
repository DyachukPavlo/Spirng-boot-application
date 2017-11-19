package com.andoliny.model.entities;

import com.andoliny.model.interfaces.DomainObject;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "country")
public class Country implements DomainObject {

    private int id;
    private String name;
    private Set<UserData> userData;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCountry", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "nationality", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<UserData> getUserData() {
        return this.userData;
    }

    public void setUserData(Set<UserData> userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
