package com.zeroli.common.base;

import android.content.Context;

import com.zeroli.common.baserx.RxManager;

/**
 * Created by zhh_li on 2016/10/13.
 */

public abstract class BasePresenter<T, E> {
    public Context mContext;

    public E mModel;
    public T mView;

    public RxManager mRxManager = new RxManager();

    public void setVM(T view, E modle) {
        this.mView = view;
        this.mModel = modle;
        this.onStart();
    }

    public void onStart() {
    }

    public void onDestroy() {
        mRxManager.clear();
    }
}
