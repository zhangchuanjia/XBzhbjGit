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
 *  @描述：    这是设置的内容控制器,用来产生新闻中心填充的View和初始化数据
 */
public class SettingController extends TabController{
    private static final String TAG = "HomeController";


    public SettingController(Context context) {
        super(context);
    }
    @Override
    public View initContentView(){
        TextView textView = new TextView(mContext);
        textView.setText("设置");
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
    @Override
    public void initData(){
        mTvTitle.setText("设置");
    }

}
