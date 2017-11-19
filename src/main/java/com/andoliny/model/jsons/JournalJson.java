package com.andoliny.model.jsons;

import com.andoliny.model.entities.Journal;

import java.util.ArrayList;
import java.util.List;

public class JournalJson {
    private int id;
    private String averAge;
    private String createDate;
    private String nationCount;
    private String sexCount;
    private int userCount;


    public JournalJson(Journal journal) {
        this.id = journal.getId();
        this.averAge = String.format("%.2f", journal.getAverAge());
        this.createDate = journal.getCreateDate().toString().replace("T", " ").substring(0,16);
        this.nationCount = journal.getNationCount();
        this.sexCount = journal.getSexCount();
        this.userCount = journal.getUserCount();
    }

    public static List<JournalJson> createJournalJsonList(List<Journal> journals) {
        List<JournalJson> journalJsons = new ArrayList<>();
        if (journals != null) {
            for (Journal journal : journals) {
                journalJsons.add(new JournalJson(journal));
            }
        }

        return journalJsons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAverAge() {
        return averAge;
    }

    public void setAverAge(String averAge) {
        this.averAge = averAge;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNationCount() {
        return nationCount;
    }

    public void setNationCount(String nationCount) {
        this.nationCount = nationCount;
    }

    public String getSexCount() {
        return sexCount;
    }

    public void setSexCount(String sexCount) {
        this.sexCount = sexCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    @Override
    public String toString() {
        return "{\"JournalJson\":{" +
                "\"d\":" + id +
                ", \"averAge\":\"" + averAge +"\""+
                ", \"createDate\":\"" + createDate +"\""+
                ", \"nationCount\":[" + nationCount + "]" +
                ", \"sexCount\":[" + sexCount + "]" +
                ", \"userCount\":" + userCount +
                "}}";
    }
}
