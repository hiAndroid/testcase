package com.wuzhong.tao.detail.view;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.wuzhong.R;
import com.wuzhong.tao.detail.animation.AnimationHelper;

/**
 * Created by wuzhong on 14-9-2.
 */
public class SKuFragment extends Fragment {

    public static final String TAG = "SkuFragment";

    private boolean ready;

    private WebView mWebview;
    private View mBlank;
    private boolean urlLoaded;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.e(TAG, "on create view");

        return inflater.inflate(R.layout.detail_fragment_sku, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        mWebview = (WebView) view.findViewById(R.id.webview);
        mBlank = view.findViewById(R.id.blank);

        mBlank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });

        ready = true;

    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    public void show(){

        if(ready){
            AnimationHelper.upIn(this.getView());
        }

        if(!urlLoaded){

            urlLoaded = true;

            if(null != mWebview){

                mWebview.setNetworkAvailable(true);
                mWebview.getSettings().setAllowContentAccess(true);
                mWebview.getSettings().setJavaScriptEnabled(true);

//                mWebview.loadUrl("http://hws.m.taobao.com/cache/wdesc/5.0/?id=19842770800");

                mWebview.loadData("<h1>hello SKU</h1>","text/html","UTF-8");
            }

        }




    }

    public boolean hide() {

        if( null != this.getView() && this.getView().getVisibility() == View.VISIBLE) {
            AnimationHelper.downOut(this.getView());
            return true;
        }

        return false;

    }
}
