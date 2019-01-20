package com.nsu.tatianadementeva.tivenue.common;

public abstract class UseCase<RequestType extends UseCase.RequestValues,
                              ResponseType extends  UseCase.ResponseValues> {

    //region Private entities
    private RequestType requestValues;
    private IUseCaseCallback<ResponseType> useCaseCallback;
    //endregion

    //region Getters and Setters
    public IUseCaseCallback<ResponseType> getUseCaseCallback() {
        return useCaseCallback;
    }

    void setUseCaseCallback(IUseCaseCallback<ResponseType> useCaseCallback) {
        this.useCaseCallback = useCaseCallback;
    }

    public RequestType getRequestValues() {
        return requestValues;
    }

    void setRequestValues(RequestType requestValues) {
        this.requestValues = requestValues;
    }
    //endregion

    //region Public interface
    void run(){
        executeUseCase(requestValues);
    }
    //endregion

    //region Should be override
    protected abstract void executeUseCase(RequestType requestValues);
    //endregion

    //region Internal types for Request and Response values
    public interface RequestValues{}
    public interface ResponseValues{}
    //endregion
}
