package com.nsu.tatianadementeva.tivenue.modules.base;

public interface IBaseView<T extends IBasePresenter> {
    void setPresenter(T presenter);
}
