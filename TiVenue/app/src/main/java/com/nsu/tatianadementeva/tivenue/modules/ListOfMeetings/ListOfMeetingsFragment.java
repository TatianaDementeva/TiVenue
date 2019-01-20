package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nsu.tatianadementeva.tivenue.R;
import com.nsu.tatianadementeva.tivenue.model.Meeting;

import java.util.ArrayList;

public class ListOfMeetingsFragment extends Fragment implements IListOfMeetingsView{

    //region Private initials
    private IListOfMeetingsPresenter presenter;
    private RecyclerView meetingRecyclerView;
    private MeetingAdapter meetingAdapter;
    //endregion

    //region Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        meetingAdapter = new MeetingAdapter(meetings);
        meetingRecyclerView.setAdapter(meetingAdapter);
    }

    //endregion

    //region MeetingHolder
    private class MeetingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleTextView;
        private Meeting meeting;

        public MeetingHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.meeting_on_list, parent, false));

            itemView.setOnClickListener(this);

            titleTextView = itemView.findViewById(R.id.title_of_meeting_on_list);
        }

        public void bind(Meeting meeting){
            this.meeting = meeting;
            titleTextView.setText(meeting.getName());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"Click!", Toast.LENGTH_SHORT).show();
        }
    }
    //endregion

    //region MeetingAdapter
    private class MeetingAdapter extends RecyclerView.Adapter<MeetingHolder> {
        private ArrayList<Meeting> meetings;

        public MeetingAdapter(ArrayList<Meeting> meetings){
            this.meetings = meetings;
        }

        @Override
        public MeetingHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new MeetingHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(MeetingHolder meetingHolder, int position) {
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