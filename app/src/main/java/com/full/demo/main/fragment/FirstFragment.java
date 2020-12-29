package com.full.demo.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.full.demo.R;
import com.full.demo.businessdemo.customview.FirstViewActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@ContentView(R.layout.fragment_first)
public class FirstFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(FirstFragment.this, inflater, container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        LeakThread leakThread = new LeakThread();
//        leakThread.start();
    }

    @Event(value = {R.id.img_setting_click})
    private void rightClick(View view) {
        startActivity(new Intent(getActivity(), FirstViewActivity.class));
    }

    // test leakCanary
//    class LeakThread extends Thread
//    {
//        @Override
//        public void run() {
//            super.run();
//            try {
//                CommonUtil.testDemo(getActivity());
//                Thread.sleep(6 * 60 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
