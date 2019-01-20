package com.nsu.tatianadementeva.tivenue.data.meetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.data.people.PeopleOrganizer;
import com.nsu.tatianadementeva.tivenue.model.Person;
import java.util.ArrayList;
import java.util.UUID;

public class MeetingsFakeDataSource implements IMeetingsDataSource {

    //region Private entities
    private ArrayList<Person> people = PeopleOrganizer.peoples();
    private ArrayList<Meeting> allMeetings = MeetingsOrganizer.meetings(people);
    private  ArrayList<Meeting> meetings = people.get(0).getMeetings();
    private static MeetingsFakeDataSource sharedInstance;
    //endregion

    public static MeetingsFakeDataSource getInstance() {
        if(null == sharedInstance){
            sharedInstance = new MeetingsFakeDataSource();
        }
        return sharedInstance;
    }
    private MeetingsFakeDataSource(){}

    //region IMeetingsDataSource
    @Override
    public void getMeetings(ILoadMeetingsCallback callback) {
        callback.onMeetingsLoaded(meetings);
    }

    @Override
    public void getMeeting(final UUID meetingId, ILoadMeetingCallback callback) {

        Meeting meeting = meetings.stream()
                .filter(a->a.getUuid().compareTo(meetingId) == 0)
                .findFirst()
                .get();

        callback.onMeetingLoaded(meeting);
    }
    //endregion
}
