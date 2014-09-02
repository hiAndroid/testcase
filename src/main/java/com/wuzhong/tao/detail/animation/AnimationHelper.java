package com.wuzhong.tao.detail.animation;

import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * Created by wuzhong on 14-9-2.
 */
public class AnimationHelper {

    public static int screen_width;
    public static int screen_height;

    private static TranslateAnimation ANIM_LEFT_IN;
    private static TranslateAnimation ANIM_RIGHT_OUT;

    private static TranslateAnimation ANIM_UP_IN;
    private static TranslateAnimation ANIM_DOWN_OUT;

    public static void init(int screen_width,int screen_height){
        AnimationHelper.screen_height = screen_height;
        AnimationHelper.screen_width = screen_width;

        AnimationHelper.ANIM_LEFT_IN = new TranslateAnimation(screen_width, 0, 0, 0);
        AnimationHelper.ANIM_RIGHT_OUT = new TranslateAnimation(0, screen_width, 0, 0);

        AnimationHelper.ANIM_UP_IN = new TranslateAnimation(0, 0, screen_height, 0);
        AnimationHelper.ANIM_DOWN_OUT = new TranslateAnimation(0, 0, 0, screen_height);

        ANIM_LEFT_IN.setDuration(ANIM_DURATION);
        ANIM_RIGHT_OUT.setDuration(ANIM_DURATION);
        ANIM_UP_IN.setDuration(ANIM_DURATION);
        ANIM_DOWN_OUT.setDuration(ANIM_DURATION);
    }

    private static int ANIM_DURATION = 500;


    public static void leftIn(View fragmentView) {
//        View fragmentView = getView();
        if (null != fragmentView && View.VISIBLE != fragmentView.getVisibility()) {

            fragmentView.setVisibility(View.VISIBLE);
            fragmentView.bringToFront();

            fragmentView.setFocusable(true);
            fragmentView.requestFocus();

            fragmentView.startAnimation(ANIM_LEFT_IN);

//            onPageEnter();
        }
    }


    public static void upIn(View fragmentView) {
//        View fragmentView = getView();
        if (null != fragmentView && View.VISIBLE != fragmentView.getVisibility()) {

            fragmentView.setVisibility(View.VISIBLE);
            fragmentView.bringToFront();

            fragmentView.setFocusable(true);
            fragmentView.requestFocus();

            fragmentView.startAnimation(ANIM_UP_IN);

//            onPageEnter();
        }
    }

    public static void rightOut(View fragmentView) {
//        View fragmentView = getView();
        if (null != fragmentView && View.GONE != fragmentView.getVisibility()) {
            fragmentView.startAnimation(ANIM_RIGHT_OUT);
            fragmentView.setVisibility(View.GONE);

//            onPageLeave();
        }
    }

    public static void downOut(View fragmentView) {
//        View fragmentView = getView();
        if (null != fragmentView && View.GONE != fragmentView.getVisibility()) {
            fragmentView.startAnimation(ANIM_DOWN_OUT);
            fragmentView.setVisibility(View.GONE);

//            onPageLeave();
        }
    }

}
