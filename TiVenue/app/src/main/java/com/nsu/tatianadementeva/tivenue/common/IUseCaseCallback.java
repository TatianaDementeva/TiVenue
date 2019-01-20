package com.nsu.tatianadementeva.tivenue.common;

public interface IUseCaseCallback<T> {

    void onSuccess(T response);
    void onError();
}
