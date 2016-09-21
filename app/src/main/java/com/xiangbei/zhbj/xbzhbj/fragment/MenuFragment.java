package com.xiangbei.zhbj.xbzhbj.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiangbei.zhbj.xbzhbj.R;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.fragment
 *  @文件名:   MenuFragment
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 11:50
 *  @描述：    TODO
 */
public class MenuFragment
        extends Fragment {
    private static final String TAG = "ContentFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_menu,null);

    }
}
