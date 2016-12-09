package com.zeroli.common.commonwidget;


import android.view.View;

/**
 * des:双击事件
 * <p>
 * Created by zhh_li on 2016/10/24.
 */

public abstract class OnDoubleClickListener implements View.OnClickListener {
    private int count = 0;
    private long firstClick = 0;
    private long secondClick = 0;


    @Override
    public void onClick(View v) {
        count++;
        if (count == 1) {
            firstClick = System.currentTimeMillis();
        } else if (count == 2) {
            secondClick = System.currentTimeMillis();
            if (secondClick - firstClick < 1000) {
                // 双击事件
                onDoubleClick(v);
            }
            count = 0;
            firstClick = 0;
            secondClick = 0;
        }
    }

    protected abstract void onDoubleClick(View v);

}

