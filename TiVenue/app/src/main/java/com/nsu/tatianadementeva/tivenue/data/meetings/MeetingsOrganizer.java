package com.nsu.tatianadementeva.tivenue.data.meetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.model.Person;
import java.util.ArrayList;


public class MeetingsOrganizer {

    public MeetingsOrganizer(){}

    public static ArrayList<Meeting> meetings(ArrayList<Person> people){
        ArrayList<Meeting> meetings = new ArrayList<>();

        Meeting meeting1 = new Meeting("Празднование 5-ки по мобилкам", people.get(0), "Супер круутая туса в честь потрясающе хорошего настроения от полученной 5-ки", people);
        people.get(0).addMeeting(meeting1);
        people.get(1).addMeeting(meeting1);
        people.get(2).addMeeting(meeting1);
        meetings.add(meeting1);

        Meeting meeting2 = new Meeting("Поход на каток", people.get(2), "Мы за активный отдых", people);
        people.get(0).addMeeting(meeting2);
        people.get(1).addMeeting(meeting2);
        people.get(2).addMeeting(meeting2);
        meetings.add(meeting2);

        Meeting meeting3 = new Meeting("Совместоное написание проекта по мобилкам", people.get(1), "Да здравствует бессонная ночь!!!", people);
        people.get(0).addMeeting(meeting3);
        people.get(1).addMeeting(meeting3);
        meetings.add(meeting3);

        Meeting meeting4 = new Meeting("Посещение ресторана", people.get(0), "Гастрономическйи отдых", people);
        people.get(0).addMeeting(meeting4);
        people.get(1).addMeeting(meeting4);
        people.get(2).addMeeting(meeting4);
        meetings.add(meeting4);

        Meeting meeting5 = new Meeting("Медиана", people.get(2), "Мы за ЗОЖ(нет конечно же, БУХИИЧЬЬЬ!!) ", people);
        people.get(0).addMeeting(meeting5);
        people.get(1).addMeeting(meeting5);
        people.get(2).addMeeting(meeting5);
        meetings.add(meeting5);

        Meeting meeting6 = new Meeting("Хочу в театр", people.get(1), "Давайте со мной!!!", people);
        people.get(0).addMeeting(meeting6);
        people.get(1).addMeeting(meeting6);
        people.get(2).addMeeting(meeting6);
        meetings.add(meeting6);

        Meeting meeting7 = new Meeting("Отчисление с НГУ", people.get(2), "КАК ЖЕ МЕНЯ ВСЕ ДОСТАЛО!!", people);
        people.get(0).addMeeting(meeting7);
        people.get(1).addMeeting(meeting7);
        people.get(2).addMeeting(meeting7);
        meetings.add(meeting7);

        return meetings;
    }



}
