package com.example.henrik.facebook_test_rightversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Sweetpink on 2016-03-06.
 */
public class Ranking  extends AppCompatActivity {

    //integer array med r drawable



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new Ranking_ImageListAdapter(this));

    }
}

