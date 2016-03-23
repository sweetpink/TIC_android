package com.example.henrik.facebook_test_rightversion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Sweetpink on 2016-03-19.
 */
public class Ranking_ImageListAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.ranking_rank1,
            R.drawable.ranking_rank2,
            R.drawable.ranking_rank3,
            R.drawable.ranking_rank4,
            R.drawable.ranking_rank5,
            R.drawable.ranking_rank6,
            R.drawable.ranking_rank7,
            R.drawable.ranking_rank8,
            R.drawable.ranking_rank9,
            R.drawable.ranking_rank10,
            R.drawable.ranking_rank11,
            R.drawable.ranking_rank12,
            R.drawable.ranking_rank13,
            R.drawable.ranking_rank14,
            R.drawable.ranking_rank15,
            R.drawable.ranking_rank16,
            R.drawable.ranking_rank17,
            R.drawable.ranking_rank18,
            R.drawable.ranking_rank19

    };

    // Constructor
    public Ranking_ImageListAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.WRAP_CONTENT, ListView.LayoutParams.WRAP_CONTENT));
        return imageView;
    }

}
