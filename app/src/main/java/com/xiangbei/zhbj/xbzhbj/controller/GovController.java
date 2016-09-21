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
 *  @描述：    这是政务的内容控制器,用来产生新闻中心填充的View和初始化数据
 */
public class GovController extends TabController {
    private static final String TAG = "HomeController";


    public GovController(Context context) {
      super(context);
    }
    @Override
    public View initContentView(){
        TextView textView = new TextView(mContext);
        textView.setText("政务");
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
    @Override
    public void initData(){
        mTvTitle.setText("政务");
    }

}
