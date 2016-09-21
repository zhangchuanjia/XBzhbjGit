package com.xiangbei.zhbj.xbzhbj.util;

import android.content.Context;
import android.content.SharedPreferences;

/*
 *  @项目名：  XBzhbj 
 *  @包名：    com.xiangbei.zhbj.xbzhbj.util
 *  @文件名:   PreferenceUtil
 *  @创建者:   zcj
 *  @创建时间:  2016/9/19 15:18
 *  @描述：    TODO
 */
public class PreferenceUtil {
    private static final String TAG = "PreferenceUtil";
    private static  SharedPreferences getConfig(Context context){
               return context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }
    public static void putBoolean(Context context , String  key, Boolean value){
        //这句我还是有些不懂的,基础班就讲的我迷迷糊糊的
        getConfig(context).edit().putBoolean(key ,value ).commit();
    }
    public static boolean getBoolean(Context context , String  key, Boolean defValue){
        return getConfig(context).getBoolean(key,defValue);
    }

    public static boolean getBoolean(Context context , String  key){
        return getConfig(context).getBoolean(key,false);
    }

}

/*
这是没整理过得.
    public static void putBoolean(Context context , String  key, Boolean value){
        //这句我还是有些不懂的,基础班就讲的我迷迷糊糊的
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        config.edit().putBoolean(key ,value ).commit();
    }
    public static boolean getBoolean(Context context , String  key, Boolean defValue){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getBoolean(key,defValue);
    }

    public static boolean getBoolean(Context context , String  key){
        SharedPreferences config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getBoolean(key,false);
    }

*
 */
