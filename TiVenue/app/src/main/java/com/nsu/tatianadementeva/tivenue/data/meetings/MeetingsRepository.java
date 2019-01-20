package com.nsu.tatianadementeva.tivenue.data.meetings;

import java.util.UUID;

public class MeetingsRepository implements IMeetingsDataSource {

    //region Data sources
    private IMeetingsDataSource meetingsFakeDataSource;
    //endregion

    //region Initialization
    public MeetingsRepository(IMeetingsDataSource meetingsFakeDataSource){
        this.meetingsFakeDataSource = meetingsFakeDataSource;
    }
    //endregion

    //region IMeetingsDataSource
    @Override
    public void getMeetings(ILoadMeetingsCallback callback) {
        if(null != callback){
            meetingsFakeDataSource.getMeetings(callback);
        }
    }

    @Override
    public void getMeeting(UUID meetingId, ILoadMeetingCallback callback) {
        if(null != callback){
            meetingsFakeDataSource.getMeeting(meetingId, callback);
        }
    }
    //endregion
}
