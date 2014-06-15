package com.example.fragmentpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    private FragmentAdapter _pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //なんでもいいけど、とりあえずページ出す内容を生成
        List<ResourceDto> resources = new ArrayList<ResourceDto>();
        for (int i = 0; i < 3; i++) {
            ResourceDto resource = new ResourceDto();
            resource.text = "page" + (i+1);
            resources.add(resource);
        }

        //adapterにpagerをセット
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setOnPageChangeListener(pagerListner);
        _pagerAdapter = new FragmentAdapter(getSupportFragmentManager());
        _pagerAdapter.setResource(resources);
        pager.setAdapter(_pagerAdapter);

        Button button = (Button)findViewById(R.id.updateaction);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFragment();
            }
        });

    }

    private void updateFragment() {

        //なんでもいいけど、とりあえずページ出す内容を生成
        List<ResourceDto> resources = new ArrayList<ResourceDto>();
        for (int i = 3; i < 6; i++) {
            ResourceDto resource = new ResourceDto();
            resource.text = "page" + (i+1);
            resources.add(resource);
        }

        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setOnPageChangeListener(pagerListner);
        _pagerAdapter.destroyAllItem(pager);
        _pagerAdapter.setResource(resources);
        _pagerAdapter.notifyDataSetChanged();
        pager.setAdapter(_pagerAdapter);

    }

    private final SimpleOnPageChangeListener pagerListner = new SimpleOnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            Log.d("current page", "" + position);
            //ここでページ毎に処理が必要な場合は、ハンドリングする
        }
    };

}
