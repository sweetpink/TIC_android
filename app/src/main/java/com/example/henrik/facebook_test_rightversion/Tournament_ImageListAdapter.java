package com.example.henrik.facebook_test_rightversion;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Tournament_ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> date;
    private ArrayList<String> imageUrlsFlags;
    private ArrayList<String> title;
    private ArrayList<String> imageUrlsLogo;

    public Tournament_ImageListAdapter(Context context, ArrayList<String> imageUrlsFlags, ArrayList<String> imageUrlsLogo,ArrayList<String> title, ArrayList<String> date) {
        super(context, R.layout.listview_tournament_layout, imageUrlsFlags);
        this.imageUrlsLogo = imageUrlsLogo;
        this.context = context;
        this.title = title;
        this.imageUrlsFlags = imageUrlsFlags;
        this.date = date;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_tournament_layout, parent, false);
        }

        Picasso
                .with(context)
                .load(imageUrlsFlags.get(position))
                .fit()
                .into((ImageView) convertView.findViewById(R.id.flag));

        Picasso
                .with(context)
                .load(imageUrlsLogo.get(position))
                .fit()
                .into((ImageView) convertView.findViewById(R.id.logo));

        TextView nameTextview = (TextView) convertView.findViewById(R.id.result_name);
        nameTextview.setText(title.get(position));
        nameTextview.setTextColor(Color.parseColor("#D9D9D9"));

        TextView dateTextview = (TextView) convertView.findViewById(R.id.date);
        dateTextview.setText(date.get(position));
        dateTextview.setTextColor(Color.parseColor("#D9D9D9"));

        if ((position % 2) == 0) {
            convertView.setBackgroundColor(Color.parseColor("#801C1C1C"));
        }
        else{
            convertView.setBackgroundColor(Color.parseColor("#800F0F0F"));
        }

        return convertView;
    }
}


