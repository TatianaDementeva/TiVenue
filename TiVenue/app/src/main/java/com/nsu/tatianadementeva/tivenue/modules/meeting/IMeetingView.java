package com.nsu.tatianadementeva.tivenue.modules.meeting;

import com.nsu.tatianadementeva.tivenue.modules.base.IBaseView;

interface IMeetingView extends IBaseView<IMeetingPresenter> {
    void setMeetingTitleTextView(String title);
    void setMeetingOrganizerTextView(String nameOrganizer);
    void setMeetingFinalDateTextView(String date);
    void setMeetingDescriptionTextView(String description);
    void setMeetingIDTextView(String meetingId);
    void setMeetingParticipantsTextView(String participants);
}
