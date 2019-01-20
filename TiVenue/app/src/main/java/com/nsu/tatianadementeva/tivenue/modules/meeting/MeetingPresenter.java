package com.nsu.tatianadementeva.tivenue.modules.meeting;

import com.nsu.tatianadementeva.tivenue.common.IUseCaseCallback;
import com.nsu.tatianadementeva.tivenue.common.UseCaseHandler;
import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.model.Person;
import java.util.ArrayList;
import java.util.UUID;

public class MeetingPresenter implements IMeetingPresenter {

    //region Private entities
    private final IMeetingView view;
    private final UseCaseHandler useCaseHandler;
    //endregion

    //region Private data
    private final UUID meetingId;
    //endregion

    //region Use cases
    private final GetMeeting getMeeting;
    //endregion

    //region Initialization
    MeetingPresenter(final IMeetingView view,
                     final UseCaseHandler useCaseHandler,
                     final UUID meetingId,
                     final GetMeeting getMeeting) {
        this.view = view;
        this.useCaseHandler = useCaseHandler;
        this.meetingId = meetingId;
        this.getMeeting = getMeeting;
    }
    //endregion

    //region IMeetingPresenter
    @Override
    public void start() {
        loadMeeting();
    }
    //endregion

    //region Private helpers
    private void loadMeeting(){
        GetMeeting.RequestValues requestValues = new GetMeeting.RequestValues(meetingId);

        useCaseHandler.execute(getMeeting, requestValues, new IUseCaseCallback<GetMeeting.ResponseValues>() {
            @Override
            public void onSuccess(GetMeeting.ResponseValues response) {
                Meeting meeting = response.getMeetings();
                processMeeting(meeting);
            }

            @Override
            public void onError() {

            }
        });
    }

    private void processMeeting(Meeting meeting){
        if (null == meeting){
            return;
        }

        String title = meeting.getName();
        String organizer = meeting.getOrganizer().getName();
        String date = meeting.getFinalDate();
        String ID = meeting.getUuid().toString();
        String description = meeting.getDescription();

        String participants= "";
        ArrayList<Person> people = meeting.getParticipants();
        for (Person i:people) {
            participants = participants.concat(i.getName());
            participants = participants.concat("\n");
        }

        if (null != organizer){
            view.setMeetingOrganizerTextView(organizer);
        }

        if (null != date){
            view.setMeetingFinalDateTextView(date);
        }

        view.setMeetingIDTextView(ID);

        if (null != description){
            view.setMeetingDescriptionTextView(description);
        }
        view.setMeetingParticipantsTextView(participants);

        if (null != title){
            view.setMeetingTitleTextView(title);
        }
    }

    @Override
    public void clickBack() {
        view.openListOfMeetings();
    }
    //endregion
}
