package com.zeroli.common.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zeroli.common.commonutils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhh_li on 2016/10/19.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mTittles;

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tittles) {
        super(fm);
        mTittles = tittles;
        mFragmentList = fragmentList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        return !CollectionUtil.isNullOrEmpty(mTittles) ? mTittles.get(position) : "";
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
