package com.nsu.tatianadementeva.tivenue.modules.meeting;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.ImageView;

import com.nsu.tatianadementeva.tivenue.R;
import com.nsu.tatianadementeva.tivenue.common.UseCaseHandler;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsFakeDataSource;
import com.nsu.tatianadementeva.tivenue.data.meetings.MeetingsRepository;
import com.nsu.tatianadementeva.tivenue.modules.base.SingleFragmentActivity;
import java.util.UUID;


public class MeetingActivity extends SingleFragmentActivity {

    public static final String EXTRA_MEETING_ID = "EXTRA_MEETING_ID";

    //region Specific fragment
    @Override
    protected Fragment createFragment() {
        return new MeetingFragment();
    }
    //endregion

    //region Life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        String meetingIdString = getIntent().getStringExtra(EXTRA_MEETING_ID);
        UUID meetingId = UUID.fromString(meetingIdString);

        UseCaseHandler useCaseHandler = UseCaseHandler.getInstance();

        MeetingsFakeDataSource meetingsFakeDataSource = MeetingsFakeDataSource.getInstance();
        MeetingsRepository meetingsRepository = new MeetingsRepository(meetingsFakeDataSource);
        GetMeeting getMeeting = new GetMeeting(meetingsRepository);

        IMeetingView view = (IMeetingView) fragment;
        IMeetingPresenter presenter = new MeetingPresenter(view, useCaseHandler, meetingId, getMeeting);
        view.setPresenter(presenter);
    }
    //endregion
}
