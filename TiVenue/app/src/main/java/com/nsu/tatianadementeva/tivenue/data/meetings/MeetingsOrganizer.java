package com.nsu.tatianadementeva.tivenue.data.meetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.model.Person;

import java.util.ArrayList;


public class MeetingsOrganizer {

    public MeetingsOrganizer(){

    }

    public static void meetings(ArrayList<Person> people){
        Meeting meeting1 = new Meeting("Празднование 5-ки по мобилкам", people.get(0), "Супер круутая туса", people);
        people.get(0).addMeeting(meeting1);
        people.get(1).addMeeting(meeting1);
        people.get(2).addMeeting(meeting1);

        Meeting meeting2 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting2);
        people.get(1).addMeeting(meeting2);
        people.get(2).addMeeting(meeting2);

        Meeting meeting3 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting3);
        people.get(1).addMeeting(meeting3);
        people.get(2).addMeeting(meeting3);

        Meeting meeting4 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting4);
        people.get(1).addMeeting(meeting4);
        people.get(2).addMeeting(meeting4);

        Meeting meeting5 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting5);
        people.get(1).addMeeting(meeting5);
        people.get(2).addMeeting(meeting5);

        Meeting meeting6 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting6);
        people.get(1).addMeeting(meeting6);
        people.get(2).addMeeting(meeting6);

        Meeting meeting7 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting7);
        people.get(1).addMeeting(meeting7);
        people.get(2).addMeeting(meeting7);

        Meeting meeting8 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting8);
        people.get(1).addMeeting(meeting8);
        people.get(2).addMeeting(meeting8);

        Meeting meeting9 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting9);
        people.get(1).addMeeting(meeting9);
        people.get(2).addMeeting(meeting9);
        
    }



}
