package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.modules.base.IBasePresenter;

interface IListOfMeetingsPresenter extends IBasePresenter {
    void clickOnMeeting(Meeting meeting);
}
