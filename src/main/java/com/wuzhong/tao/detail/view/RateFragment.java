package com.wuzhong.tao.detail.view;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wuzhong.R;
import com.wuzhong.tao.detail.animation.AnimationHelper;

/**
 * Created by wuzhong on 14-9-2.
 */
public class RateFragment extends Fragment {

    public static final String TAG = "RateFragment";

    private boolean ready;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.e(TAG, "on create view");

        return inflater.inflate(R.layout.detail_fragment_rate, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        ready = true;

    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    public void show(){

        if(ready){

            AnimationHelper.leftIn(this.getView());

        }

    }
}
