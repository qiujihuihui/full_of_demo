package com.full.demo.businessdemo.recycleview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.full.demo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemoFragment extends Fragment {

    private RecyclerView recyclerView;

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
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        demoAdapter = new RecyclerDemoAdapter(getActivity(), titlesList);
        recyclerView.setAdapter(demoAdapter);
        demoAdapter.setOnItemsClickListener(new OnItemsClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                new AlertDialog.Builder(getActivity()).setTitle("删除？").setPositiveButton("确定", (dialogInterface, i) -> demoAdapter.removeItem(position)).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
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
