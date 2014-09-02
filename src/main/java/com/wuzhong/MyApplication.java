package com.wuzhong;

import android.app.Application;
import android.util.DisplayMetrics;
import android.util.Log;
import com.wuzhong.tao.detail.animation.AnimationHelper;

/**
 * Created by wuzhong on 14-9-2.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();

        float density  = dm.density;        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
//        int densityDPI = dm.densityDpi;     // 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;

        AnimationHelper.init((int)(xdpi * density), (int)(ydpi*density));

        Log.e("app", AnimationHelper.screen_width + "dp");


//        int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽（像素，如：480px）
//        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();




    }
}
