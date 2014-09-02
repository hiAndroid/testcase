/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wuzhong;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.wuzhong.animation.*;
import com.wuzhong.tao.detail.DetailActivity;

/**
 * The launchpad activity for this sample project. This activity launches other activities that
 * demonstrate implementations of common animations.
 */
public class MainActivity extends ListActivity {
    /**
     * This class describes an individual sample (the sample title, and the activity class that
     * demonstrates this sample).
     */
    private class Sample {
        private String title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        public Sample(String title, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = title;
        }


        @Override
        public String toString() {
            return title.toString();
        }
    }

    private static Sample[] mSamples;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the list of samples.
        mSamples = new Sample[]{
                new Sample("Detail Activity", DetailActivity.class),
                new Sample(R.string.title_crossfade, CrossfadeActivity.class),
                new Sample(R.string.title_card_flip, CardFlipActivity.class),
                new Sample(R.string.title_screen_slide, ScreenSlideActivity.class),
                new Sample(R.string.title_zoom, ZoomActivity.class),
                new Sample(R.string.title_layout_changes, LayoutChangesActivity.class),
                new Sample("Tree Fragment", LayoutChangesActivity.class),
        };

        setListAdapter(new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mSamples));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
//        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
        Sample sample = mSamples[position];
        if(sample.title.contains("Fragment")){



        }else {
            startActivity(new Intent(MainActivity.this, sample.activityClass));
        }
    }
}
