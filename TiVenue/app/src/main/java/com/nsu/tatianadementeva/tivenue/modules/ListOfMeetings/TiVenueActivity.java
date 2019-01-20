package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.nsu.tatianadementeva.tivenue.R;
import com.nsu.tatianadementeva.tivenue.common.UseCaseHandler;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsFakeDataSource;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsRepository;
import com.nsu.tatianadementeva.tivenue.modules.base.SingleFragmentActivity;

public class TiVenueActivity extends SingleFragmentActivity {

    //region Private entities
    private IListOfMeetingsPresenter presenter;
    private ImageView menu;
    private ImageView group_add;
    private ImageView create_meeting;
    //endregion

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

        menu = findViewById(R.id.menu);
        group_add = findViewById(R.id.group_add);
        create_meeting = findViewById(R.id.create_meeting);

         menu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(v.getContext(),"Click on icon menu!", Toast.LENGTH_SHORT).show();
             }
         });
         group_add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(v.getContext(),"Click on icon group add!", Toast.LENGTH_SHORT).show();
             }
         });
         create_meeting.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(v.getContext(),"Click on icon create meeting!", Toast.LENGTH_SHORT).show();

             }
         });

        UseCaseHandler useCaseHandler = UseCaseHandler.getInstance();

        MeetingsFakeDataSource meetingsFakeDataSource = new MeetingsFakeDataSource();
        MeetingsRepository meetingsRepository = new MeetingsRepository(meetingsFakeDataSource);
        GetMeetings getMeetings = new GetMeetings(meetingsRepository);

        IListOfMeetingsView view = (IListOfMeetingsView) fragment;
        presenter = new ListOfMeetingsPresenter(view, useCaseHandler, getMeetings);
        view.setPresenter(presenter);
    }
    //endregion
}