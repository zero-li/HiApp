package com.zeroli.hiapp.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import com.zeroli.hiapp.R;

public class SplashActivty extends AppCompatActivity {

    AnimatorSet animatorSet = new AnimatorSet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView _iv = (ImageView) findViewById(R.id._iv);

        _iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.start();
            }
        });

        // http://mp.weixin.qq.com/s?__biz=MzI4MTQyNDg3Mg==&mid=2247483687&idx=1&sn=964ec9f4c681cd6bdade8b65d7399222#rd
        // alpha：控制view透明度，默认是1（不透明），0完全透明（不可见）
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha",1f, 1.8f);
        // scaleX、scaleY：控制view绕支点进行2D缩放
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(_iv,alpha,scaleX,scaleY);

        animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(3000);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivty.this,MainActivity.class));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();

    }
}
