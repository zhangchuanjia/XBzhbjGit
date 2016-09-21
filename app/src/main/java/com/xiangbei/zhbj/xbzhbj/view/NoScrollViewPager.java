package com.xiangbei.zhbj.xbzhbj.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.view
 *  @文件名:   NoScrollViewPager
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 22:22
 *  @描述：    TODO
 */
public class NoScrollViewPager extends ViewPager{
    private static final String TAG = "NoScrollViewPager";

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
