package com.nsu.tatianadementeva.tivenue.data.meetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;
import java.util.ArrayList;
import java.util.UUID;

public interface IMeetingsDataSource {
    interface  ILoadMeetingsCallback{
        void onMeetingsLoaded(ArrayList<Meeting> meetings);
    }
    void getMeetings(ILoadMeetingsCallback callback);

    interface ILoadMeetingCallback{
        void onMeetingLoaded(Meeting meeting);
    }

    void getMeeting(UUID meetingId, ILoadMeetingCallback callback);
}
