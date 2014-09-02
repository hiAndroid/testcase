package com.wuzhong.tao.detail.animation;

import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * Created by wuzhong on 14-9-2.
 */
public class AnimationHelper {

    public static int screen_width;
    public static int screen_height;

    private static TranslateAnimation ANIM_LEFT_IN =
            new TranslateAnimation(screen_width, 0, 0, 0);
    private static TranslateAnimation ANIM_RIGHT_OUT =
            new TranslateAnimation(0, screen_width, 0, 0);

    private static int ANIM_DURATION = 3000;

    static {
        ANIM_LEFT_IN.setDuration(ANIM_DURATION);
        ANIM_RIGHT_OUT.setDuration(ANIM_DURATION);
    }

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

    public static void rightOut(View fragmentView) {
//        View fragmentView = getView();
        if (null != fragmentView && View.GONE != fragmentView.getVisibility()) {
            fragmentView.startAnimation(ANIM_RIGHT_OUT);
            fragmentView.setVisibility(View.GONE);

//            onPageLeave();
        }
    }

}
