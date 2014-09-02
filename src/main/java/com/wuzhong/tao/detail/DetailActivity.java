package com.wuzhong.tao.detail;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import com.wuzhong.R;
import com.wuzhong.tao.detail.animation.AnimationHelper;
import com.wuzhong.tao.detail.model.Unit;
import com.wuzhong.tao.detail.view.DescFragment;
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
    private DescFragment descFragment;
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

        this.rateFragment = new RateFragment();
        addFragment(this.rateFragment,RateFragment.TAG);

        this.descFragment = new DescFragment();
        addFragment(this.descFragment,DescFragment.TAG);
    }

    private void addFragment(Fragment fragment,String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        rateFragment = new RateFragment();
        fragmentTransaction.add(R.id.viewport, fragment, tag);
        fragmentTransaction.hide(fragment);
//        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(Unit unit) {

        if (7 == unit.type) {
            rateFragment.show();
        }

        if( 0 == unit.type){
            descFragment.show();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(rateFragment.hide()){
                return true;
            }

            if(descFragment.hide()){
                return true;
            }

        }
        return super.onKeyDown(keyCode,event);
    }
}
