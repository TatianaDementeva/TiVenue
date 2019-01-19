package com.nsu.tatianadementeva.tivenue.model;

import java.util.ArrayList;
import java.util.UUID;

public class MeetingsOrganizer {

    public MeetingsOrganizer(){

    }

    public void meetings(ArrayList<Person> people){
        Meeting meeting1 = new Meeting("Празднование 5-ки по мобилкам", people.get(0), "Супер круутая туса", people);
        people.get(0).addMeeting(meeting1);
        people.get(1).addMeeting(meeting1);
        people.get(2).addMeeting(meeting1);

        Meeting meeting2 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting2);
        people.get(1).addMeeting(meeting2);
        people.get(2).addMeeting(meeting2);
        
    }



}
