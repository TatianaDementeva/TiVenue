package com.nsu.tatianadementeva.tivenue.data.meetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;

import java.util.ArrayList;

public interface IMeetingsDataSource {
    interface  ILoadMeetingsCallback{
        void onMeetingsLoaded(ArrayList<Meeting> meetings);
    }
    void getMeetings(ILoadMeetingsCallback callback);
}
