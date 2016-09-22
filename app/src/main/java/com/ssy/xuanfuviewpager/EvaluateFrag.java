package com.ssy.xuanfuviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by gavin on 2016/9/21.
 */
public class EvaluateFrag extends Fragment {
    private MyListView lv;

    private CatalogAdapter adapter;

    private ArrayList<Integer> data;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, null);
        lv = (MyListView) view.findViewById(R.id.catalog_lv);
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(i, i);
        }

        adapter = new CatalogAdapter(getActivity(), data);
        lv.setAdapter(adapter);
        return view;
    }


}
