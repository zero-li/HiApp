package com.zeroli.commom.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.umeng.analytics.MobclickAgent;
import com.zeroli.commom.baseapp.AppManager;
import com.zeroli.commom.commonutils.TUtil;

import butterknife.ButterKnife;

/**
 * Created by zhh_li on 2016/10/13.
 */

/***************使用例子*********************/
//1.mvp模式
//public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleActivity extends BaseActivity {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public E mModel;
    public Context mContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        doBeforSetContentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);

        if (mPresenter != null) {
            mPresenter.mContext = this;
        }

        this.initPresenter();
        this.initView();

    }

    /**
     * 设置layout前配置
     */
    private void doBeforSetContentView() {
        //设置昼夜主题
        // initTheme();

        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);

        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /*********************
     * 子类实现
     *****************************/
    // 获取布局文件
    public abstract int getLayoutId();

    // mvp场景
    public abstract void initPresenter();

    // 初始化view
    public abstract void initView();


    @Override
    protected void onResume() {
        super.onResume();
        //debug版本不统计crash
        if (!com.zeroli.commom.BuildConfig.LOG_DEBUG) {
            // 友盟统计
            MobclickAgent.onResume(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //debug版本不统计crash
        if (!com.zeroli.commom.BuildConfig.LOG_DEBUG) {
            // 友盟统计
            MobclickAgent.onResume(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.OnDestroy();
        }
        ButterKnife.unbind(this);

        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivty(Class<?> cls) {
        startActivity(cls, null);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    public void startActivity(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }


}
