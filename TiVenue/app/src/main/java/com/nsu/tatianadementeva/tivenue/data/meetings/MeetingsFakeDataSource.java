package com.nsu.tatianadementeva.tivenue.data.meetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.data.people.PeopleOrganizer;
import com.nsu.tatianadementeva.tivenue.model.Person;

import java.util.ArrayList;

public class MeetingsFakeDataSource implements IMeetingsDataSource {

    //region IMeetingsDataSource
    @Override
    public void getMeetings(ILoadMeetingsCallback callback) {
        ArrayList<Person> people = PeopleOrganizer.peoples();
        MeetingsOrganizer.meetings(people);
        ArrayList<Meeting> meetings = people.get(0).getMeetings();

        callback.onMeetingsLoaded(meetings);
    }
    //endregion
}
