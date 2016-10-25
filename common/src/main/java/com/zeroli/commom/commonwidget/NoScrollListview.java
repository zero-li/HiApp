package com.zeroli.commom.commonwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * des: 不会滚动的listview
 *
 * Created by zhh_li on 2016/10/24.
 */

public class NoScrollListview extends ListView {
    public NoScrollListview(Context context) {
        super(context);
    }

    public NoScrollListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
