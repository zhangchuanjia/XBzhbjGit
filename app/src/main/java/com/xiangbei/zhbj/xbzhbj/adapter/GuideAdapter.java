package com.xiangbei.zhbj.xbzhbj.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/*
 *  @项目名：  XBzhbj
 *  @包名：    com.xiangbei.zhbj.xbzhbj.adapter
 *  @文件名:   GuideAdapter
 *  @创建者:   zcj
 *  @创建时间:  2016/9/18 23:54
 *  @描述：    TODO
 */
public class GuideAdapter extends PagerAdapter {
    private static final String TAG = "GuideAdapter";
    Context mContext;
    List<View> mList;

    public GuideAdapter(Context context, List<View> list) {
        mContext = context;
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
        View view = mList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
