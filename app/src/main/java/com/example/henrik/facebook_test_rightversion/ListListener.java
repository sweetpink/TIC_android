package com.example.henrik.facebook_test_rightversion;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;


public class ListListener implements AdapterView.OnItemClickListener {

    private final List<String> row;
    private Activity activity;
    public ListListener(Activity anActivity, List<String> row) {
        this.activity  = anActivity;
        this.row = row;
    }

    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("https://hypefinder.com/webroot/" + row.get(pos)));

        activity.startActivity(webIntent);
    }
}
