package com.example.henrik.facebook_test_rightversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Henrik on 2016-03-24.
 */
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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        TextView nameTextview = (TextView) convertView.findViewById(R.id.result_name);
        nameTextview.setText(title.get(position));

        TextView dateTextview = (TextView) convertView.findViewById(R.id.date);
        dateTextview.setText(date.get(position));

        return convertView;
    }
}


