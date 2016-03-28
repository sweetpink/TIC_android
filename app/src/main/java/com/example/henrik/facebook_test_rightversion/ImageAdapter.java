package com.example.henrik.facebook_test_rightversion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;

    }

    //Images to be loaded
    private Integer[] mThumbIds = {
        R.drawable.character_akuma, R.drawable.character_alisa, R.drawable.character_asuka,
        R.drawable.character_bryan, R.drawable.character_claudio, R.drawable.character_deviljin,
        R.drawable.character_dragunov, R.drawable.character_feng, R.drawable.character_gigas,
        R.drawable.character_heihachi, R.drawable.character_hwoarang, R.drawable.character_jack7,
        R.drawable.character_jin, R.drawable.character_josie, R.drawable.character_katarina,
        R.drawable.character_kazumi, R.drawable.character_kazuya, R.drawable.character_king,
        R.drawable.character_lars, R.drawable.character_law, R.drawable.character_leo,
        R.drawable.character_lili, R.drawable.character_luckychloe, R.drawable.character_nina,
        R.drawable.character_paul, R.drawable.character_shaheen, R.drawable.character_steve,
        R.drawable.character_xiaoyu,R.drawable.character_yoshimitsu
    };
}