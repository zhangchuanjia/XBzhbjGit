package com.xiangbei.zhbj.xbzhbj.controller;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xiangbei.zhbj.xbzhbj.util.Constent;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.controller
 *  @文件名:   HomeController
 *  @创建者:   zcj
 *  @创建时间:  2016/9/20 19:35
 *  @描述：    这是新闻中心的内容控制器,用来产生新闻中心填充的View和初始化数据
 */
public class NewsController extends TabController {
    private static final String TAG = "HomeController";


    public NewsController(Context context) {
       super(context);
    }
    @Override
    public View initContentView(){
        TextView textView = new TextView(mContext);
        textView.setText("新闻中心");
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
    @Override
    public void initData(){
        mTvTitle.setText("新闻中心");
        getData();
    }

    public void getData() {
        RequestQueue queue = Volley.newRequestQueue(mContext);

        StringRequest request = new StringRequest(Constent.KEY_NEWS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //response
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(mContext , "code:0010" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
