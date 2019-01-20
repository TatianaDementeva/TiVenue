package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import com.nsu.tatianadementeva.tivenue.common.UseCase;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsRepository;
import com.nsu.tatianadementeva.tivenue.model.Meeting;

import java.util.ArrayList;

public class GetMeetings extends UseCase<GetMeetings.RequestValues, GetMeetings.ResponseValues> {

    //region Private entities
    private final MeetingsRepository meetingsRepository;
    //endregion

    //region Initialization
    GetMeetings(MeetingsRepository meetingsRepository) {
        this.meetingsRepository = meetingsRepository;
    }
    //endregion

    //region UseCase
    @Override
    protected void executeUseCase(final RequestValues requestValues) {
        meetingsRepository.getMeetings(meetings -> {
            ResponseValues responseValue = new ResponseValues(meetings);
            getUseCaseCallback().onSuccess(responseValue);
        });
    }
    //endregion

    //region Request and Response values types
    public static final class RequestValues implements UseCase.RequestValues {
        private boolean fetchFromFakeStore;

        RequestValues(boolean fetchFromFakeStore) {
            this.fetchFromFakeStore = fetchFromFakeStore;
        }

        public boolean isFetchFromFakeStore() {
            return fetchFromFakeStore;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private  final ArrayList<Meeting> meetings;

        ResponseValues(ArrayList<Meeting> meetings) {
            this.meetings = meetings;
        }

        public ArrayList<Meeting> getMeetings() {
            return meetings;
        }
    }
    //endregion
}
