package com.full.demo.main;

import android.os.Bundle;
import android.util.Log;

import com.full.demo.R;
import com.full.demo.businessdemo.recycleview.RecyclerViewDemoFragment;
import com.full.demo.main.fragment.FeaturedFragment;
import com.full.demo.main.fragment.FirstFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

/**
 * 主页，嵌套各个fragment
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.view_page)
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        MainFragmentPageAdapter fragmentPageAdapter = new MainFragmentPageAdapter(this, getFragments());
        viewPager.setAdapter(fragmentPageAdapter);
        getLifecycle().addObserver(locationListener);
    }

    MyLocationListener locationListener = new MyLocationListener(new MyLocationListener.OnLocationChangeListener()
    {
        @Override
        public void onChanged(double latitude, double longitude) {
            Log.d("LocationListener", "position has moved :" + latitude + "  -- " + longitude);
        }

        @Override
        public void positionChanged(String message) {
            Log.d("LocationListener", message);
        }
    });

    private List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new RecyclerViewDemoFragment());
        fragments.add(new RecyclerViewDemoFragment());
        fragments.add(new FeaturedFragment());
        return fragments;
    }
}
