package com.wuzhong.tao.detail;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.wuzhong.R;
import com.wuzhong.tao.detail.animation.AnimationHelper;
import com.wuzhong.tao.detail.model.Unit;
import com.wuzhong.tao.detail.view.DetailMainPageAdapter;
import com.wuzhong.tao.detail.view.RateFragment;
import com.wuzhong.tao.detail.view.ViewClickListener;

/**
 * Created by wuzhong on 14-9-2.
 */
public class DetailActivity extends Activity implements ViewClickListener {


    private Context mContext;
    private FragmentManager fragmentManager;
    private RateFragment rateFragment;
//    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        this.fragmentManager = getFragmentManager();

        setContentView(R.layout.detail_layout);

        ListView listView = (ListView) findViewById(R.id.listview);

//        final Context mContext = this;

        listView.setAdapter(new DetailMainPageAdapter(this));

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        rateFragment = new RateFragment();

        fragmentTransaction.add(R.id.viewport, rateFragment, RateFragment.TAG);
        fragmentTransaction.hide(rateFragment);
        fragmentTransaction.addToBackStack(RateFragment.TAG);
        fragmentTransaction.commitAllowingStateLoss();


    }

    @Override
    public void onClick(Unit unit) {

        if (7 == unit.type) {

            rateFragment.show();

        }


    }
}
