package com.nsu.tatianadementeva.tivenue.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Meeting {
    //region Private properties
    private UUID uuid;
    private String name;
    private Person organizer;
    private Date finalDate;
    private String description;
    private ArrayList<Person> participants;
    //endregion

    //region Initialization
    public Meeting(String name, Person organizer, String description, ArrayList<Person> participants) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.organizer = organizer;
        this.description = description;
        this.participants = participants;
    }
    //endregion

    //region Getters
    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Person> getParticipants() {
        return participants;
    }
    //endregion

}
