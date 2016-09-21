package com.xiangbei.zhbj.xbzhbj.controller;

import android.content.Context;
import android.view.View;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.controller
 *  @文件名:   BaseController
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 20:03
 *  @描述：    这是所有Controller的基类,用来定义Controller必须遵守的规则.两个抽象方法子类去自己实现,提供共有的返回view的方法.
 *
 */
public abstract class BaseController {
    private static final String TAG = "BaseController";

    Context mContext;
    private final View mView;
    //TODO:这里的Context传过来传过去晕了.java基础不好把..
    // TODO:这个子类构造调用父类构造后 父类构造接到context然后执行了initView.是这也样吗?
    // TODO:为什么initView里面也传了context,但子类实现的时候并没有传.
    public BaseController(Context context) {
        mContext = context;
        mView = initView();

    }

    /**
     *
     */
    public abstract View initView();

    /**
     *
     */
    public abstract  void  initData();


    /**
     *
     * @return
     */
    public View getRootView(){
        return mView;
    }
}
