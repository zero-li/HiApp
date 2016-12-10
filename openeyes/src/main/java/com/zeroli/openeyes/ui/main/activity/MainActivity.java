package com.zeroli.openeyes.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.zeroli.common.base.BaseActivity;
import com.zeroli.common.daynightmodeutils.ChangeModeController;
import com.zeroli.openeyes.R;
import com.zeroli.openeyes.bean.TabEntity;

import java.util.ArrayList;

import butterknife.Bind;


public class MainActivity extends BaseActivity {

    @Bind(R.id.tab_layout)
    CommonTabLayout mTabLayout;

    private String[] mTittles = {"精选", "发现", "关注", "我的"};
    private int[] mIconUnselectIds = {R.drawable.ic_tab_strip_icon_feed,
            R.drawable.ic_tab_strip_icon_category,
            R.drawable.ic_tab_strip_icon_follow,
            R.drawable.ic_tab_strip_icon_profile};
    private int[] mIconSelectIds = {R.drawable.ic_tab_strip_icon_feed_selected,
            R.drawable.ic_tab_strip_icon_category_selected,
            R.drawable.ic_tab_strip_icon_follow_selected,
            R.drawable.ic_tab_strip_icon_profile_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>(4);


    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public boolean initFullScreen() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        mTabLayout.measure(0, 0);

        initTab();


    }

    private void initTab() {
        for (int i = 0; i < mTittles.length; i++) {
            mTabEntities.add(new TabEntity(mTittles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ChangeModeController.getInstance().init(this, R.attr.class);
        super.onCreate(savedInstanceState);
        initFragment(savedInstanceState);
    }

    private void initFragment(Bundle savsavedInstanceState) {
    }
}
