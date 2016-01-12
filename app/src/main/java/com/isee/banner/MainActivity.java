package com.isee.banner;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.isee.banner.bean.NewsItem;
import com.isee.banner.view.HeadlinesView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HeadlinesView headlinesView;
    private List<NewsItem> list;
    private ImageView bannerImage;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        initData();

        headlinesView.refreshData(list);

    }

    private void initData() {
        list = new ArrayList<NewsItem>();
        NewsItem item1 = new NewsItem("banner1",R.mipmap.banner1,"http://www.45fair.com/uploads/ad_jpg/logo1.jpg");
        NewsItem item2 = new NewsItem("banner2",R.mipmap.banner2,"http://www.45fair.com/uploads/ad_jpg/logo2.jpg");
        NewsItem item3 = new NewsItem("banner3",R.mipmap.banner1,"http://www.45fair.com/uploads/ad_jpg/logo3.png");
        NewsItem item4 = new NewsItem("banner4",R.mipmap.banner2,"http://www.45fair.com/uploads/ad_jpg/logo4.png");
        NewsItem item5 = new NewsItem("banner5",R.mipmap.banner1,"http://www.45fair.com/uploads/ad_jpg/logo3.png");
        list.add(item1);list.add(item2);list.add(item3);list.add(item4);list.add(item5);

        Glide.with(this).load("http://www.45fair.com/uploads/ad_jpg/logo1.jpg").placeholder(R.mipmap.banner1).into(bannerImage);
       // ImageLoader.getInstance().displayImage("http://www.45fair.com/uploads/ad_jpg/logo1.jpg",bannerImage,MyApplication.getInstance().getOptions());

        refreshLayout.setColorSchemeColors(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorAccent);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                initData();
                headlinesView.refreshData(list);
                headlinesView.startAutoScroll();
                refreshLayout.setRefreshing(false);
            }


        });
    }

    private void findviews() {
        headlinesView = (HeadlinesView) findViewById(R.id.headlines);
        bannerImage = (ImageView) findViewById(R.id.banner1);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        headlinesView.startAutoScroll();

    }

    @Override
    protected void onStop() {
        super.onStop();
        headlinesView.stopAutoScroll();
    }
}
