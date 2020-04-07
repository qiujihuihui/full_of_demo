package com.full.demo.businessdemo.recycleview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.full.demo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemoFragment extends Fragment {

    RecyclerView recyclerView;

    private RecyclerDemoAdapter demoAdapter;
    private List<String> titlesList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview_demo, container, false);
        recyclerView = view.findViewById(R.id.rv);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        demoAdapter = new RecyclerDemoAdapter(getActivity(), titlesList);
        recyclerView.setAdapter(demoAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (int i = 0 ; i < 10 ; ++i){
            titlesList.add("title:" + i);
        }
        demoAdapter.notifyDataSetChanged();
    }
}
