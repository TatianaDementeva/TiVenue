package com.nsu.tatianadementeva.tivenue.modules.ListOfMeetings;

import com.nsu.tatianadementeva.tivenue.common.IUseCaseCallback;
import com.nsu.tatianadementeva.tivenue.common.UseCaseHandler;
import com.nsu.tatianadementeva.tivenue.model.Meeting;

import java.util.ArrayList;

public class ListOfMeetingsPresenter implements IListOfMeetingsPresenter {

    //region Private entities
    private IListOfMeetingsView view;
    private UseCaseHandler useCaseHandler;
    //endregion

    //region Use cases
    private GetMeetings getMeetings;
    //endregion

    //region Initialization
    public ListOfMeetingsPresenter(IListOfMeetingsView view, UseCaseHandler useCaseHandler, GetMeetings getMeetings) {
        this.view = view;
        this.useCaseHandler = useCaseHandler;
        this.getMeetings = getMeetings;
    }
    //endregion

    //region IListOfMeetingsPresenter
    @Override
    public void start() {
        loadMeetings();
    }
    //endregion

    //region Private helpers
    private void loadMeetings(){
        final GetMeetings.RequestValues requestValues = new GetMeetings.RequestValues(true);

        useCaseHandler.execute(getMeetings, requestValues, new IUseCaseCallback<GetMeetings.ResponseValues>() {
            @Override
            public void onSuccess(GetMeetings.ResponseValues response) {
                ArrayList<Meeting> meetings = response.getMeetings();
                processMeetings(meetings);
            }

            @Override
            public void onError() {

            }
        });
    }

    private void processMeetings(ArrayList<Meeting> meetings){
        view.showMeetings(meetings);
    }
    //endregion


}
