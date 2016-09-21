package com.xiangbei.zhbj.xbzhbj.controller;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiangbei.zhbj.xbzhbj.R;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.controller
 *  @文件名:   BaseController
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 20:03
 *  @描述：    这是带有标题栏和内容框体的Controller的基类,用来定义Controller必须遵守的规则.两个抽象方法子类去自己实现,提供共有的返回view的方法.
 *
 */
public abstract class TabController extends BaseController{
    private static final String TAG = "BaseController";
    public TextView mTvTitle;
    public ImageView mIvLeft;

    public TabController(Context context) {
        super(context);
    }

    /**
     *
     */
    @Override
    public  View initView(){
        //
        View view= View.inflate(mContext, R.layout.tab_content, null);

        mIvLeft = (ImageView) view.findViewById(R.id.iv_tab_left);
        mTvTitle = (TextView) view.findViewById(R.id.tv_tab_title);
        //
        FrameLayout container = (FrameLayout) view.findViewById(R.id.fl_container);
        //
        container.addView(initContentView());
        return view;
    }

    /**
     *
     * @return
     */
    protected abstract View initContentView();

    ;

}
