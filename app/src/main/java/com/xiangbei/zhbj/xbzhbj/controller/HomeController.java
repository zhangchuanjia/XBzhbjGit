package com.xiangbei.zhbj.xbzhbj.controller;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.controller
 *  @文件名:   HomeController
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 19:35
 *  @描述：   这是首页的内容控制器,用来产生新闻中心填充的View和初始化数据
 */
public class HomeController extends TabController {
    private static final String TAG = "HomeController";


    public HomeController(Context context) {
       super(context);
    }

    /**
     *
     * 初始化视图的方法.
     * @return 返回一个可以填充到Viewpager的View.
     */
    @Override
    public View initContentView(){
        TextView textView = new TextView(mContext);
        textView.setText("首页");
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
    /**
     * 初始化数据的方法.
     */
    @Override
    public void initData(){
        mIvLeft.setVisibility(View.GONE);
        mTvTitle.setText("首页");

    }


}
