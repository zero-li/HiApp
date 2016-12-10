package com.zeroli.openeyes.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * des: 自定义 TextView
 * Created by zhh_li
 * on 2016/12/10.
 */

public class CustomTextView extends TextView{
    public CustomTextView(Context context) {
        super(context);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    /**
     * 设置字体
     * @param context
     */
    private void init(Context context){
        AssetManager assetManager = context.getAssets();
        Typeface font = Typeface.createFromAsset(assetManager,"fonts/Lobster-1.4.otf");
        setTypeface(font);

    }
}
