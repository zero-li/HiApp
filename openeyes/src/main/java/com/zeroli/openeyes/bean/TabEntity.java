package com.zeroli.openeyes.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * des:
 * Created by zhh_li
 * on 2016/12/10.
 */

public class TabEntity implements CustomTabEntity {
    private String title;
    private int selectIcon;
    private int unselectIcon;

    public TabEntity(String title, int selectIcon, int unselectIcon) {
        this.title = title;
        this.selectIcon = selectIcon;
        this.unselectIcon = unselectIcon;
    }


    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectIcon;
    }
}
