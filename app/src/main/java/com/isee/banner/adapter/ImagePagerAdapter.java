package com.isee.banner.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.isee.banner.MyApplication;
import com.isee.banner.R;
import com.isee.banner.bean.NewsItem;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * desc: 纯图片PagerAdapter
 * author: kinneyYan
 * date: 2015/7/1
 */
public class ImagePagerAdapter extends RecyclingPagerAdapter {

    private Context context;
    private List<NewsItem> list;

    public ImagePagerAdapter(Context context, List<NewsItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            convertView = holder.imageView = imageView;
            convertView.setTag(R.id.banner_imageview_holder,holder);
        } else {
            holder = (ViewHolder) convertView.getTag(R.id.banner_imageview_holder);
        }

        final NewsItem item = list.get(position);
        if (null != item) {
          // ImageLoader.getInstance().displayImage(item.getRemoteImage(), holder.imageView, MyApplication.getInstance().getOptions());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
          //  holder.imageView.setImageResource(item.getImageUrl());
           Glide.with(context).load(item.getRemoteImage()).placeholder(R.mipmap.banner1).into(holder.imageView);

        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
    }

}
