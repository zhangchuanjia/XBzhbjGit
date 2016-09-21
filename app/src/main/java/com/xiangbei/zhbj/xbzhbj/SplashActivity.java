package com.xiangbei.zhbj.xbzhbj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.xiangbei.zhbj.xbzhbj.util.Constent;
import com.xiangbei.zhbj.xbzhbj.util.PreferenceUtil;

/**
 * 启动界面要加动画
 * 界面结束时跳到导航界面
 *
 */
public class SplashActivity
        extends Activity
        implements Animation.AnimationListener
{

    private RelativeLayout mRlSplash;
    private AnimationSet   mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        mRlSplash = (RelativeLayout) findViewById(R.id.rl_splash);
    }

    private void initData() {
        //设置动画
        ferformAnimation();
    }

    /**
     * 启动动画.
     */
    private void ferformAnimation() {
        //Declear an animation set.
        mSet = new AnimationSet(true);
        mSet.setInterpolator(new BounceInterpolator());
        //        缩放动画
        ScaleAnimation sAnim = new ScaleAnimation(0,
                                                  1,
                                                  0,
                                                  1,
                                                  Animation.RELATIVE_TO_PARENT,
                                                  0.5f,
                                                  Animation.RELATIVE_TO_PARENT,
                                                  0.5f);
        sAnim.setDuration(600);
        //旋转动画
        RotateAnimation rAnim = new RotateAnimation(0,
                                                    360,
                                                    Animation.RELATIVE_TO_PARENT,
                                                    0.5f,
                                                    Animation.RELATIVE_TO_PARENT,
                                                    0.5f);
        rAnim.setDuration(1500);
        mSet.addAnimation(rAnim);
        mSet.addAnimation(sAnim);
        mRlSplash.startAnimation(mSet);
    }

    private void initListener() {
        mSet.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //动画结束,如果已经显示完成导航页,进导航页
        /*
        * if(走完了导航页){
        * 进主页}else{
        * 继续显示导航页}*/
        boolean isGuideFinished = PreferenceUtil.getBoolean(this, Constent.KEY_GUIDE_FINISH);
        if (isGuideFinished) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        }
        finish();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
