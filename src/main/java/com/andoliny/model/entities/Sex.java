package com.andoliny.model.entities;

import com.andoliny.model.interfaces.DomainObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sex")
public class Sex implements DomainObject {

    private int idSex;
    private String description;
    private Set<UserData> userData = new HashSet<>(0);

    public Sex() {
    }

    public Sex(String description, Set<UserData> userData) {
        this.description = description;
        this.userData = userData;
    }

    public Sex(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idSex", unique = true, nullable = false)
    public int getIdSex() {
        return idSex;
    }

    public void setIdSex(int idSex) {
        this.idSex = idSex;
    }

    @Column(name = "description", unique = true, nullable = false, length = 10)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "sex", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<UserData> getUserData() {
        return this.userData;
    }

    public void setUserData(Set<UserData> userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "idSex=" + idSex +
                ", description=" + description +
                '}';
    }
}
