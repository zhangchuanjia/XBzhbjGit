package com.xiangbei.zhbj.xbzhbj.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.xiangbei.zhbj.xbzhbj.R;
import com.xiangbei.zhbj.xbzhbj.adapter.ContentAdapter;
import com.xiangbei.zhbj.xbzhbj.controller.BaseController;
import com.xiangbei.zhbj.xbzhbj.controller.GovController;
import com.xiangbei.zhbj.xbzhbj.controller.HomeController;
import com.xiangbei.zhbj.xbzhbj.controller.NewsController;
import com.xiangbei.zhbj.xbzhbj.controller.SSController;
import com.xiangbei.zhbj.xbzhbj.controller.SettingController;
import com.xiangbei.zhbj.xbzhbj.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;


/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.fragment
 *  @文件名:   ContentFragment
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 11:50
 *  @描述：    TODO
 */
public class ContentFragment
        extends Fragment
        implements RadioGroup.OnCheckedChangeListener
{
    private static final String TAG = "ContentFragment";
    private View              mView;
    private NoScrollViewPager mViewPager;
    private RadioGroup        mRadioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        mView = inflater.inflate(R.layout.fragment_content, null);
        initView();

        initData();
        initListener();
        return mView;

    }


    private void initView() {
        mViewPager = (NoScrollViewPager) mView.findViewById(R.id.content_viewpager);
        mRadioGroup = (RadioGroup) mView.findViewById(R.id.radio_group);
    }

    /**
     * getActivity () 得到宿主的实例对象,其实这里就是MainActivity.
     * 这个很重要,要通过这个上下文和其他的类产生联结.
     *
     * 先产生一个view的集合用来做初步的展示信息.
     *
     * 设置适配器.
     *
     */
    private void initData() {
        List<BaseController> list = new ArrayList<>();
        Log.d("aaa","listkankan看看"+list);
        list.add(new HomeController(getActivity()));
        list.add(new NewsController(getActivity()));
        list.add(new SSController(getActivity()));
        list.add(new GovController(getActivity()));
        list.add(new SettingController(getActivity()));

        //设置适配器
        ContentAdapter adapter = new ContentAdapter(list);
        mViewPager.setAdapter(adapter);
    }

  /*  @NonNull
    private List<View> getListNoUse() {//声明一个装View的集合.用来传给适配器.
        List<View> list = new ArrayList<>();

        //这里先产生几个测试的view .后面将使用真正的东西去填充ViewPager.
        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(getActivity());
            textView.setText("这是内容页==" + i);
            //TODO:这里的18是像素吗?
            textView.setTextSize(18);
            textView.setGravity(Gravity.CENTER);

            list.add(textView);
        }
        return list;
    }
*/

    private void initListener() {
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case  R.id.rb_home:
                mViewPager.setCurrentItem(0);
                break;
            case  R.id.rb_news:
                mViewPager.setCurrentItem(1);
                break;
            case  R.id.rb_gov:
                mViewPager.setCurrentItem(2);
                break;
            case  R.id.rb_ss:
                mViewPager.setCurrentItem(3);
                break;
            case  R.id.rb_setting:
                mViewPager.setCurrentItem(4);
                break;

        }
    }
}
