package com.nsu.tatianadementeva.tivenue.modules.meeting;

import com.nsu.tatianadementeva.tivenue.common.UseCase;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsRepository;
import com.nsu.tatianadementeva.tivenue.model.Meeting;
import java.util.UUID;

public class GetMeeting extends UseCase<GetMeeting.RequestValues, GetMeeting.ResponseValues> {

    //region Private entities
    private final MeetingsRepository meetingsRepository;
    //endregion

    //region Initialization
    GetMeeting(MeetingsRepository meetingsRepository) {
        this.meetingsRepository = meetingsRepository;
    }
    //endregion

    //region UseCase
    @Override
    protected void executeUseCase(RequestValues requestValues) {

        UUID meetingId = requestValues.getMeetingId();
        meetingsRepository.getMeeting(meetingId, meeting -> {
            ResponseValues responseValue = new ResponseValues(meeting);
            getUseCaseCallback().onSuccess(responseValue);
        });
    }
    //endregion

    //region Request and Response values types
    static final class RequestValues implements UseCase.RequestValues {
        private final UUID meetingId;

        RequestValues(UUID meetingId) {
            this.meetingId = meetingId;
        }

        UUID getMeetingId() {
            return meetingId;
        }
    }

    static final class ResponseValues implements UseCase.ResponseValues {
        private  final Meeting meeting;

        ResponseValues(Meeting meeting) {
            this.meeting = meeting;
        }

        Meeting getMeetings() {
            return meeting;
        }
    }
    //endregion
}
