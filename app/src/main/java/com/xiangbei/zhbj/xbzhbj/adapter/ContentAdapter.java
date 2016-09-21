package com.xiangbei.zhbj.xbzhbj.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.xiangbei.zhbj.xbzhbj.controller.BaseController;

import java.util.List;

/*
 *  @项目名：  XBzhbj
 *  @包名：    com.xiangbei.zhbj.xbzhbj.adapter
 *  @文件名:   ContentAdapter
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 18:26
 *  @描述：    TODO
 */
public class ContentAdapter extends PagerAdapter{
    private static final String TAG = "ContentAdapter";
    List<BaseController> mList;

    public ContentAdapter(List<BaseController> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //
        BaseController controller = mList.get(position);
        View view = controller.getRootView();
        //
        container.addView(view);
        //

        //
        controller.initData();
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //
        container.removeView((View) object);
    }

}
