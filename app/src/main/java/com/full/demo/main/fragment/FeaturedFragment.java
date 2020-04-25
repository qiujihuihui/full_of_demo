package com.full.demo.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.full.demo.R;
import com.full.demo.main.adapter.FeaturedAdapter;
import com.full.demo.main.model.FeaturedBean;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ContentView(R.layout.fragment_featured)
public class FeaturedFragment extends Fragment {

    @ViewInject(R.id.mine_toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.layout_collapsing)
    CollapsingToolbarLayout toolbarLayout;
    @ViewInject(R.id.recycle_view)
    RecyclerView recyclerView;

    private List<FeaturedBean> featuredBeans;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        toolbarLayout.setTitle(getActivity().getResources().getString(R.string.app_name));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if (featuredBeans == null){
            featuredBeans = new ArrayList<>();
        } else {
            featuredBeans.clear();
        }
        recyclerView.setAdapter(new FeaturedAdapter(getActivity(), getFeaturedBeans()));
    }

    private List<FeaturedBean> getFeaturedBeans(){
        for (int i = 0 ; i < 20 ; i++){
            FeaturedBean bean = new FeaturedBean();
            bean.setTitle("This is a item , number:" + i);
            featuredBeans.add(bean);
        }
        return featuredBeans;
    }
}
