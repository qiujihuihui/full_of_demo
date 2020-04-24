package com.full.demo.businessdemo.tab;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.full.demo.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyTabActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.pic_love);
        actionBar.setDisplayHomeAsUpEnabled(true);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.layout_abs);
        drawerLayout = findViewById(R.id.dl_main_layout);
        NavigationView navigationView = findViewById(R.id.nv_main_navigation);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(item -> {
                item.setChecked(true);
                String title = item.getTitle().toString();
                Toast.makeText(MyTabActivity.this, title, Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                return true;
            });
        }
        initViewPage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tb_setting){
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initViewPage() {
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("电影");
        titles.add("电视剧");
        titles.add("纪录片");
        titles.add("娱乐");
        titles.add("游戏");
        titles.add("动漫");
        titles.add("戏曲");
        titles.add("艺术");
        for (int i = 0 ; i < titles.size() ; i++){
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0 ; i < titles.size() ; i++){
            fragments.add(new ListFragment());
        }
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);
    }
}
