package com.example.a23androidtabhostvaviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
{
    ViewPager viewPager;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        tabHost = findViewById(R.id.tab);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabHost.setup();
        TabHost.TabSpec tab1 = tabHost.newTabSpec("Music");
        tab1.setIndicator("Music");
        tab1.setContent(new FakeContentTab(MainActivity.this));

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Music");
        tab2.setIndicator("Album");
        tab2.setContent(new FakeContentTab(MainActivity.this));

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Music");
        tab3.setIndicator("List");
        tab3.setContent(new FakeContentTab(MainActivity.this));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);


        tabHost.setOnTabChangedListener(MainActivity.this);
        viewPager.setOnPageChangeListener(MainActivity.this);
    }
    // sự kiện click của tabhost
    @Override
    public void onTabChanged(String tabId)
    {
        int viTri = tabHost.getCurrentTab();
        viewPager.setCurrentItem(viTri);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }
    // sự kiện view pager kéo qua lại tabhost sẽ chuyển theo
    @Override
    public void onPageSelected(int position)
    {
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }

    public class FakeContentTab implements TabHost.TabContentFactory
    {
        Context context;
        public FakeContentTab(Context context)
        {
            this.context = context;
        }

        @Override
        public View createTabContent(String tag)
        {
            View view = new View(context);
            view.setMinimumHeight(0);
            view.setMinimumWidth(0);
            return view;
        }
    }
}
