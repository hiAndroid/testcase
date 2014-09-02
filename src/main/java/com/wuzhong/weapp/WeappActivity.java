//package com.wuzhong.weapp;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import com.taobao.weapp.WeAppEngine;
//import com.taobao.weapp.adapter.WeAppImageDownloadAdapter;
//import com.taobao.weapp.adapter.WeAppImageQuality;
//import com.wuzhong.R;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//
///**
// * Created by wuzhong on 14-8-5.
// */
//public class WeappActivity extends Activity {
//
//    private final Handler safeHandler = new Handler(Looper.getMainLooper());
//
//    private Activity mActivity;
//    LinearLayout linearLayout;
//
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        linearLayout = (LinearLayout) this.findViewById(R.id.list);
//
//
////        TextView textView = new TextView(this.getApplicationContext());
////
////        textView.setText("hello");
////        linearLayout.addView(textView);
//
//        mActivity = this;
//
//        render();
//
//
//    }
//
//
//    public void render() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//
//                    final String json = getResultForHttpGet("http://jiawulu.3322.org/scan-twodim/combo.json");
//
//                    Log.d("WeappActivity", json);
//
//                    safeHandler.post(new Runnable() {
//
//                        @Override
//                        public void run() {
//
//                            WeAppEngine mEngine = new WeAppEngine(mActivity, json);
//
//                            mEngine.setImageDownloadAdapter(new WeAppImageDownloadAdapter() {
//
//
//                                @Override
//                                public boolean setBackgroundDrawable(String s, View view, View view2, WeAppImageQuality weAppImageQuality) {
//                                    return false;
//                                }
//
//                                @Override
//                                public boolean setImageDrawable(String s, ImageView imageView, View view, WeAppImageQuality weAppImageQuality) {
//
//
//
//                                    return false;
//                                }
//
//                                @Override
//                                public void destroy() {
//
//                                }
//
//                                @Override
//                                public void recycle() {
//
//                                }
//
//                                @Override
//                                public void pauseImageDownload() {
//
//                                }
//
//                                @Override
//                                public void resumeImageDownload() {
//
//                                }
//                            });
//
//                            View view = mEngine.render();
//                            if (view != null) {
//                                linearLayout.addView(view);
//                            }
//
//                        }
//
//                    });
//
//                } catch (Throwable e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
//
//    }
//
//    public String getResultForHttpGet(String uri) throws ClientProtocolException, IOException {
//        //服务器  ：服务器项目  ：servlet名称
//        //name:服务器端的用户名，pwd:服务器端的密码
//        //注意字符串连接时不能带空格
//
//        String result = "";
//
//        HttpGet httpGet = new HttpGet(uri);
//        //取得HTTP response
//        HttpResponse response = new DefaultHttpClient().execute(httpGet);
//        //若状态码为200
//        if (response.getStatusLine().getStatusCode() == 200) {
//            //取出应答字符串
//            HttpEntity entity = response.getEntity();
//            result = EntityUtils.toString(entity, HTTP.UTF_8);
//        }
//        return result;
//    }
//
//
//}
