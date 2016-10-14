package com.zeroli.commom.base;

import android.content.Context;

/**
 * Created by zhh_li on 2016/10/13.
 */

public abstract class BasePresenter <T,E>{
    public Context mContext;

    public E mModel;
    public T mView;

    public void setVM(T view, E modle){
        this.mView = view;
        this.mModel=modle;

    }

    public void onStart(){}

    public void OnDestroy(){

    }
}
