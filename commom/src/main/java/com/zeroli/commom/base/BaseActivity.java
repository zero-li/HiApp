package com.zeroli.commom.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by zhh_li on 2016/10/13.
 */

public abstract class BaseActivity <T extends BasePresenter,E extends BaseModel> extends AppCompatActivity{
    public T mPresenter;
    public E mModel;
    public Context mContext;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);



    }

    /**
     * 设置layout前配置
     */
    private void doBeforSetContentView(){
        //设置昼夜主题
        // initTheme();

        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /*********************子类实现*****************************/
    // 获取布局文件
    public abstract int getContentViewLayoutId();
    // mvp场景
    public abstract void initPresenter();
    // 初始化view
    public abstract void initView();


    /**
     * 含有Bundle通过Class跳转界面
     */
    public void startActivity(Class<?> cls, Bundle bundle){
        Intent intent = new Intent(this,cls);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivty(Class<?> cls){
        startActivity(cls,null);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode){
        Intent intent = new Intent(this, cls);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requestCode);
    }

    public void startActivity(Class<?> cls, int requestCode){
        startActivityForResult(cls,null, requestCode);
    }




}
