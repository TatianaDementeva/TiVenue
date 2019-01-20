package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.modules.base.IBaseView;
import java.util.ArrayList;

public interface IListOfMeetingsView extends IBaseView<IListOfMeetingsPresenter> {
    void showMeetings(ArrayList<Meeting> meetings);
    void openMeetingFullScreen(String meetingId);
}
