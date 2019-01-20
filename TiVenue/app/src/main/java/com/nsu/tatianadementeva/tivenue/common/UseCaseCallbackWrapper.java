package com.nsu.tatianadementeva.tivenue.common;

public class UseCaseCallbackWrapper<T extends UseCase.ResponseValues> implements IUseCaseCallback<T> {

    //region Private entities
    private final IUseCaseCallback<T> callback;
    private final UseCaseHandler useCaseHandler;
    //endregion

    //region Initialization
    public UseCaseCallbackWrapper(IUseCaseCallback<T> callback, UseCaseHandler useCaseHandler) {
        this.callback = callback;
        this.useCaseHandler = useCaseHandler;
    }
    //endregion

    //region IUseCaseCallback
    @Override
    public void onSuccess(T response) {
        useCaseHandler.notifyResponse(response, callback);
    }

    @Override
    public void onError() {
        useCaseHandler.notifyError(callback);
    }
    //endregion
}
