package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nsu.tatianadementeva.tivenue.R;
import com.nsu.tatianadementeva.tivenue.model.Meeting;
import com.nsu.tatianadementeva.tivenue.modules.meeting.MeetingActivity;

import java.util.ArrayList;

public class ListOfMeetingsFragment extends Fragment implements IListOfMeetingsView{

    //region Private initials
    private IListOfMeetingsPresenter presenter;
    private RecyclerView meetingRecyclerView;
    //endregion

    //region Lifecycle
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_meetings, container, false);

        meetingRecyclerView = view.findViewById(R.id.list_of_meetings_recycler_view);
        meetingRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.start();
    }
    //endregion

    //region IListOfMeetingsView
    @Override
    public void setPresenter(IListOfMeetingsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMeetings(ArrayList<Meeting> meetings) {
        MeetingAdapter meetingAdapter = new MeetingAdapter(meetings);
        meetingRecyclerView.setAdapter(meetingAdapter);
    }

    @Override
    public void openMeetingFullScreen(String meetingId) {
        Intent intent = new Intent(getContext(), MeetingActivity.class);
        intent.putExtra(MeetingActivity.EXTRA_MEETING_ID, meetingId);
        startActivity(intent);

    }
    //endregion

    //region MeetingHolder
    private class MeetingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleTextView;
        private Meeting meeting;

        MeetingHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.meeting_on_list, parent, false));

            itemView.setOnClickListener(this);

            titleTextView = itemView.findViewById(R.id.title_of_meeting_on_list);
        }

        void bind(Meeting meeting){
            this.meeting = meeting;
            titleTextView.setText(meeting.getName());
        }

        @Override
        public void onClick(View v) {
            presenter.clickOnMeeting(meeting);
        }
    }
    //endregion

    //region MeetingAdapter
    private class MeetingAdapter extends RecyclerView.Adapter<MeetingHolder> {
        private ArrayList<Meeting> meetings;

        MeetingAdapter(ArrayList<Meeting> meetings){
            this.meetings = meetings;
        }

        @NonNull
        @Override
        public MeetingHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new MeetingHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MeetingHolder meetingHolder, int position) {
            Meeting meeting = meetings.get(position);
            meetingHolder.bind(meeting);
        }

        @Override
        public int getItemCount() {
            return meetings.size();
        }
    }
    //endregion
}