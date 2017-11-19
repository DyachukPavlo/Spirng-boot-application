package com.andoliny.model.entities;

import com.andoliny.model.interfaces.DomainObject;
import com.andoliny.utils.UUIDGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_core", uniqueConstraints = {
        @UniqueConstraint(columnNames = "uuid")})
public class User implements DomainObject {
    private Integer id;
    private String login;
    private String password;
    private UUID uuid;
    private UserData userData;
    private LocalDateTime creationDate;


    public User(String login, String password, UserData userData) {
        this.login = login;
        this.password = password;
        this.uuid = UUIDGenerator.generate();
        this.userData = userData;
    }

    public User() {
        this.uuid = UUIDGenerator.generate();
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.uuid = UUIDGenerator.generate();
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "login", unique = true, nullable = false, length = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "pasword", unique = false, nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
        userData.setUser(this);
    }

    @Column(name = "uuid", unique = true, nullable = false)
    @Type(type = "pg-uuid")
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    @NotNull
    @Column(name = "creation_date", nullable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", uuid='" + uuid + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", userData=" + userData +
                '}';
    }
}
