package com.example.henrik.facebook_test_rightversion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Minkan on 2016-03-23.
 */
public class TutorialAdapter extends ArrayAdapter<TutorialObject> {

    public TutorialAdapter(Context context, ArrayList<TutorialObject> tut) {
        super(context, R.layout.tutorial_row, tut);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.tutorial_row, parent, false);

        TextView title = (TextView) customView.findViewById(R.id.titleView);
        ImageView img = (ImageView) customView.findViewById(R.id.uploader);

        title.setText(getItem(position).getTitle());
        img.setImageResource(getItem(position).getImg());

        return customView;
    }
}
