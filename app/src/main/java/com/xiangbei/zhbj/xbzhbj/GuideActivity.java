package com.xiangbei.zhbj.xbzhbj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.xiangbei.zhbj.xbzhbj.adapter.GuideAdapter;
import com.xiangbei.zhbj.xbzhbj.util.Constent;
import com.xiangbei.zhbj.xbzhbj.util.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj
 *  @文件名:   GuideActivity
 *  @创建者:   zcj
 *  @创建时间:  2016/9/18 21:35
 *  @描述：    TODO
 */
public class GuideActivity
        extends Activity
        implements ViewPager.OnPageChangeListener, View.OnClickListener


{
    private static final String TAG = "GuideActivity";
    private ViewPager  mViewPager;
    private List<View> mList;
    int[] mGuide = {R.drawable.guide_1,
                    R.drawable.guide_2,
                    R.drawable.guide_3,};
    private int             mSize;
    private LinearLayout    mLldot;
    private ImageView       mReddot;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;
    private int mInVert;
    private Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
        initListener();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API)
                                                   .build();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mBtnStart = (Button) findViewById(R.id.btn_start);


        mLldot = (LinearLayout) findViewById(R.id.ll_dot);
        mReddot = (ImageView) findViewById(R.id.red_dot);
    }

    private void initData() {

        initPager();

        initDot();

        PagerAdapter adapter = new GuideAdapter(this, mList);
        mViewPager.setAdapter(adapter);


    }

    private void initDot() {
        mSize = getResources().getDimensionPixelSize(R.dimen.dot_size);
        for (int i = 0; i < mGuide.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.dot_normal);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mSize, mSize);
            if (i != 0) {
                params.leftMargin = mSize;
            }
            imageView.setLayoutParams(params);
            mLldot.addView(imageView);
        }

        //如何在oncreate 方法里拿到控件宽高的值呢? 要做一个Viewtree监听
        mLldot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //每当视图发生变化时这个方法就会被调用, 调用完成立即解绑就好了
                mInVert =  mLldot.getChildAt(1).getLeft()
                        - mLldot.getChildAt(0).getLeft();

                mLldot.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }

    //初始化ViewPager后面的图片,setAdapter后就可以滑动图片了.
    private void initPager() {
        mList = new ArrayList<>();
        for (int i = 0; i < mGuide.length; i++) {
            //使用代码创建imageview
            ImageView iv = new ImageView(this);
            //设定iv的资源
            iv.setImageResource(mGuide[i]);
            //设定宽高,这个好像是必须的.
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            //将产生的imageView添加到list集合传给Adapter显示.
            mList.add(iv);
        }
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(this);
        mBtnStart.setOnClickListener(this);
        //        mViewPager.setOnPageChangeListener(this);
    }

    /**
     *
     * @param position   which is this page position.
     * @param positionOffset How many persent to the whole screen you have scrolled.
     * @param positionOffsetPixels How man pixels you have scrolled about the screen.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //How long the screen moving.

        int mInVert =  mLldot.getChildAt(1).getLeft() - mLldot.getChildAt(0).getLeft();
        int moveDx = Math.round((mSize + mSize) * positionOffset) + position * mInVert;
        //Move the red dot.
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mSize, mSize);
        params.leftMargin = moveDx;
        mReddot.setLayoutParams(params);


    }

    @Override
    public void onPageSelected(int position) {
        //if the positon is last one  buttonStart can be visible.
        mBtnStart.setVisibility(position == mList.size() -1 ? View.VISIBLE :View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        //点击进入主页
        startActivity(new Intent( this , MainActivity.class));
        PreferenceUtil.putBoolean(this , Constent.KEY_GUIDE_FINISH, true);
        finish();
    }
}
