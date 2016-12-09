package com.zeroli.common.base;

/**
 * Created by zhh_li on 2016/10/13.
 */

public interface BaseView <T>{
    /*******内嵌加载*******/
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
