package com.nsu.tatianadementeva.tivenue.common;

public class UseCaseHandler {

    //region Private entities
    private static UseCaseHandler sharedInstance;
    private final IUseCaseScheduler useCaseScheduler;
    //endregion

    //region Singleton initialization
    public static UseCaseHandler getInstance() {
        if(null == sharedInstance){
            sharedInstance = new UseCaseHandler(new UseCaseThreadPoolScheduler());
        }
        return sharedInstance;
    }

    private UseCaseHandler(IUseCaseScheduler useCaseScheduler) {
        this.useCaseScheduler = useCaseScheduler;
    }
    //endregion

    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValues> void execute(
            final UseCase<T,R> useCase, T requestValues, IUseCaseCallback<R> callback) {

        useCase.setRequestValues(requestValues);
        useCase.setUseCaseCallback(new UseCaseCallbackWrapper<>(callback, this));

        useCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    <T extends UseCase.ResponseValues> void notifyResponse(T response, IUseCaseCallback<T> useCaseCallback){
        useCaseScheduler.onResponse(response, useCaseCallback);
    }
    <T extends UseCase.ResponseValues> void notifyError(IUseCaseCallback<T> useCaseCallback){
        useCaseScheduler.onError(useCaseCallback);
    }
}
