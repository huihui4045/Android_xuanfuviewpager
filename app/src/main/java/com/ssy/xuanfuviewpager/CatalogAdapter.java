package com.ssy.xuanfuviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gavin on 2016/5/20.
 */
public class CatalogAdapter extends BaseAdapter {
    private Context con;

    private ArrayList<Integer> dataList;

    public CatalogAdapter(Context con, ArrayList<Integer> dataList) {
        this.con = con;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(con, R.layout.item_catlog, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.tv_num);
        tv.setText(dataList.get(position) + "");

        return convertView;
    }
}
