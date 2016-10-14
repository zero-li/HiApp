package com.zeroli.commom.base;

/**
 * Created by zhh_li on 2016/10/13.
 */

public interface BaseView <T>{
    void setPresenter(T presenter);

    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
