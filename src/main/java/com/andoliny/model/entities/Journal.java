package com.andoliny.model.entities;

import com.andoliny.model.interfaces.DomainObject;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "journal")
public class Journal implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "creation_date", nullable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime createDate;

    @Column(name = "user_count")
    private int userCount;

    @Column(name = "averAge")
    private double averAge;

    @Column(name = "sex_count")
    private String sexCount;

    @Column(name = "nation_count")
    private String nationCount;

    public Journal() {
    }

    public Journal(LocalDateTime createDate, int userCount, double averAge, String sexCount, String nationCount) {
        this.createDate = createDate;
        this.userCount = userCount;
        this.averAge = averAge;
        this.sexCount = sexCount;
        this.nationCount = nationCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public double getAverAge() {
        return averAge;
    }

    public void setAverAge(double averAge) {
        this.averAge = averAge;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getSexCount() {
        return sexCount;
    }

    public void setSexCount(String sexCount) {
        this.sexCount = sexCount;
    }

    public String getNationCount() {
        return nationCount;
    }

    public void setNationCount(String nationCount) {
        this.nationCount = nationCount;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", userCount=" + userCount +
                ", averAge=" + averAge +
                ", sexCount='" + sexCount + '\'' +
                ", nationCount='" + nationCount + '\'' +
                '}';
    }
}
