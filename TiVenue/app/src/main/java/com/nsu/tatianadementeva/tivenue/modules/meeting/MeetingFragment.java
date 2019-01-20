package com.nsu.tatianadementeva.tivenue.modules.meeting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nsu.tatianadementeva.tivenue.R;

public class MeetingFragment extends Fragment implements IMeetingView {

    //region UI Outlets
    private TextView meetingTitleTextView;
    private TextView meetingOrganizerTextView;
    private TextView meetingFinalDateTextView;
    private TextView meetingDescriptionTextView;
    private TextView meetingIDTextView;
    private TextView meetingParticipantsTextView;
    //endregion

    //region Private entities
    private IMeetingPresenter presenter;
    //endregion

    //region Life cycle
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting, container, false);
        configureView(view);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.start();
    }
    //endregion

    //region View Configuration
    private void configureView(View view) {
        meetingTitleTextView = view.findViewById(R.id.meeting_title);
        meetingOrganizerTextView = view.findViewById(R.id.meeting_organizer_text);
        meetingFinalDateTextView = view.findViewById(R.id.meeting_final_date_text);
        meetingDescriptionTextView = view.findViewById(R.id.meeting_description_text);
        meetingIDTextView = view.findViewById(R.id.meeting_id_text);
        meetingParticipantsTextView = view.findViewById(R.id.meeting_participants_text);
    }
    //endregion

    //region Setters for UI Outlets
    @Override
    public void setPresenter(IMeetingPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setMeetingTitleTextView(String title) {
        meetingTitleTextView.setText(title);
    }

    @Override
    public void setMeetingOrganizerTextView(String nameOrganizer) {
        meetingOrganizerTextView.setText(nameOrganizer);
    }

    @Override
    public void setMeetingFinalDateTextView(String date) {
        meetingFinalDateTextView.setText(date);
    }

    @Override
    public void setMeetingDescriptionTextView(String description) {
        meetingDescriptionTextView.setText(description);
    }

    @Override
    public void setMeetingIDTextView(String meetingId) {
        meetingIDTextView.setText(meetingId);
    }

    @Override
    public void setMeetingParticipantsTextView(String participants) {
        meetingParticipantsTextView.setText(participants);
    }
    //endregion
}
