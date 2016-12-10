package com.zeroli.openeyes.ui.main.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.zeroli.common.base.BaseActivity;
import com.zeroli.openeyes.R;
import com.zeroli.openeyes.widget.CustomTextView;

import butterknife.Bind;

/**
 * des:
 * Created by zhh_li
 * on 2016/12/10.
 */

public class SplashActivity extends BaseActivity {
    @Bind(R.id.splash_iv_logo)
    ImageView mSplashIvLogo;
    @Bind(R.id.splash_tv_app)
    CustomTextView mSplashTvApp;
    @Bind(R.id.splash_bg)
    ImageView mSplashBg;

    @Override
    public boolean initFullScreen() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_splash;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        // http://mp.weixin.qq.com/s?__biz=MzI4MTQyNDg3Mg==&mid=2247483687&idx=1&sn=964ec9f4c681cd6bdade8b65d7399222#rd
        // alpha：控制view透明度，默认是1（不透明），0完全透明（不可见）
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.5f, 1f);
        // scaleX、scaleY：控制view绕支点进行2D缩放
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.8f, 1.1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.8f, 1.1f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(mSplashIvLogo, alpha, scaleX, scaleY);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(mSplashTvApp, alpha, scaleX, scaleY);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(1000);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                MainActivity.startAction(SplashActivity.this);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();

        PropertyValuesHolder scaleX2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.05f);
        PropertyValuesHolder scaleY2 = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.05f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(mSplashBg, scaleX2, scaleY2);
        objectAnimator3.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator3.setRepeatCount(ObjectAnimator.INFINITE);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(objectAnimator3);
        animatorSet3.start();

    }


}
