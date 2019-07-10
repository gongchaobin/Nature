package com.gong.nature.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gong.nature.ListItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/7/10 11:02 AM
 * @desc :
 */
public class RecyclerViewFragment extends Fragment{

    private RecyclerView.RecycledViewPool mViewPool;
    private List<String> mArrays;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView rv = new RecyclerView(inflater.getContext());
        LinearLayoutManager lM = new LinearLayoutManager(inflater.getContext());
        lM.setRecycleChildrenOnDetach(true);
        rv.setLayoutManager(lM);

        if(mViewPool != null) {
            rv.setRecycledViewPool(mViewPool);
        }

        mArrays = new ArrayList<>();
        for(int i= 0;i<20;i++) {
            mArrays.add(String.valueOf(i));
        }

        ListItemAdapter itemAdapter = new ListItemAdapter(inflater.getContext(),mArrays);
        rv.setAdapter(itemAdapter);

        return rv;
    }


    public void setViewPool(RecyclerView.RecycledViewPool viewPool) {
        mViewPool = viewPool;
    }

}
