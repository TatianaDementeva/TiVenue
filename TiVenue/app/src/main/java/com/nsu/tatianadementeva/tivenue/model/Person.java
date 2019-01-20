package com.nsu.tatianadementeva.tivenue.model;

import java.util.ArrayList;
import java.util.UUID;

public class Person {

    //region Private properties
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private ArrayList<Meeting> meetings;
    //endregion


    //region Initialization
    public Person(String name, String email, String password) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.meetings = new ArrayList<>();
    }
    //endregion

    //region Getters
    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeeting(Meeting meeting) {
        this.meetings.add(meeting);
    }
    //endregion
}
