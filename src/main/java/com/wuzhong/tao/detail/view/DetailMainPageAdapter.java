package com.wuzhong.tao.detail.view;

import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.wuzhong.R;
import com.wuzhong.tao.detail.model.DetailDataSource;
import com.wuzhong.tao.detail.model.Unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuzhong on 14-9-2.
 */
public class DetailMainPageAdapter implements ListAdapter {

    public List<Unit> dataSources;

    public ViewClickListener viewClickListener;

    private Map<Integer, View> viewCache = new HashMap<Integer, View>();

    public DetailMainPageAdapter(ViewClickListener viewClickListener) {

        this.dataSources = new DetailDataSource().dataSource;

        this.viewClickListener = viewClickListener;

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {

        if ( 0 == position || 7 == position) {
            return true;
        }

        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return dataSources.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSources.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataSources.get(position).type;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        Log.d("adapter", "get view at position " + position);

        int viewType = getItemViewType(position);

        if (viewCache.containsKey(viewType)) {
            return viewCache.get(viewType);
        }
        final Unit unit = (Unit) this.getItem(position);
        View mContainer = null;

        switch (unit.type) {

            case 0:
                mContainer = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.detail_main_image, null);
                break;

            default:

                mContainer = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.detail_lines, null);

                TextView textView = (TextView) mContainer.findViewById(R.id.textview);
                textView.setText(unit.value);
        }

        mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewClickListener.onClick(unit);

//                    Toast.makeText(parent.getContext(),"hello world",1000);
//


            }
        });

        viewCache.put(viewType, mContainer);
        return mContainer;
    }

    @Override
    public int getItemViewType(int position) {
        return dataSources.get(position).type;
    }

    @Override
    public int getViewTypeCount() {
        return dataSources.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
