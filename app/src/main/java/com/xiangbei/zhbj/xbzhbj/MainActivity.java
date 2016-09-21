package com.xiangbei.zhbj.xbzhbj;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.xiangbei.zhbj.xbzhbj.fragment.ContentFragment;
import com.xiangbei.zhbj.xbzhbj.fragment.MenuFragment;

public class MainActivity extends SlidingActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSlidingMenu();
        initFragment();

    }

    private void initFragment() {
        //1.获得管理者
        FragmentManager manager = getFragmentManager();
        //2.拿到事物
        FragmentTransaction  fragmentTransaction = manager.beginTransaction();
        //3.添加要现实的Fragment
        fragmentTransaction.add(R.id.fl_main, new ContentFragment());
        fragmentTransaction.add(R.id.fl_menu, new MenuFragment());
        //4.开启事物
        fragmentTransaction.commit();
    }

    /**
     *
     *初始化滑动菜单
     */
    private void initSlidingMenu() {//设置背后的布局.
        setBehindContentView(R.layout.activity_menu);
        //拿到实例对象.
        SlidingMenu menu = new SlidingMenu(this);
        //设置拉出来后主页剩了多少像素.
        menu.setBehindOffset(200);
        //设置拉出来的模式,左右都行.
        menu.setMode(SlidingMenu.LEFT);
        //设置整个屏幕都能按下拖拽
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置拖拽出来的东西跟着主页面的滑动比例一起出来.
        menu.setBehindScrollScale(0.35f);

        //设置阴影
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);

        //颜色渐变
        menu.setFadeDegree(0.35f);
    }


}
