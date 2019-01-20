package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.Toast;
import com.nsu.tatianadementeva.tivenue.R;
import com.nsu.tatianadementeva.tivenue.common.UseCaseHandler;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsFakeDataSource;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsRepository;
import com.nsu.tatianadementeva.tivenue.modules.base.SingleFragmentActivity;

public class TiVenueActivity extends SingleFragmentActivity {

    //region Specific fragment
    @Override
    protected Fragment createFragment() {
        return new ListOfMeetingsFragment();
    }
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_venue);

        ImageView menu = findViewById(R.id.menu);
        ImageView group_add = findViewById(R.id.group_add);
        ImageView create_meeting = findViewById(R.id.create_meeting);

         menu.setOnClickListener(v -> Toast.makeText(v.getContext(),"This should be menu!", Toast.LENGTH_SHORT).show());
         group_add.setOnClickListener(v -> Toast.makeText(v.getContext(),"This should be function join the meeting!", Toast.LENGTH_SHORT).show());
         create_meeting.setOnClickListener(v -> Toast.makeText(v.getContext(),"This should be function create meeting", Toast.LENGTH_SHORT).show());

        UseCaseHandler useCaseHandler = UseCaseHandler.getInstance();

        MeetingsFakeDataSource meetingsFakeDataSource = MeetingsFakeDataSource.getInstance();
        MeetingsRepository meetingsRepository = new MeetingsRepository(meetingsFakeDataSource);
        GetMeetings getMeetings = new GetMeetings(meetingsRepository);

        IListOfMeetingsView view = (IListOfMeetingsView) fragment;

        IListOfMeetingsPresenter presenter = new ListOfMeetingsPresenter(view, useCaseHandler, getMeetings);
        view.setPresenter(presenter);
    }
    //endregion
}