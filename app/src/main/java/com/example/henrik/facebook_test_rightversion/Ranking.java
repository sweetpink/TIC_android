package com.example.henrik.facebook_test_rightversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;


public class Ranking  extends AppCompatActivity {

    private TextView promotionPoints;
    private TextView demotionPoints;
    private long[] points = {88,88,80,80,80,72,72,72,72,64,64,64,64,56,56,56,56,48,48,48,48,40,40,40,40,32,32,32,32,24,24,24,24,16,16,16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        promotionPoints = (TextView) findViewById(R.id.promotionPoints);
        demotionPoints = (TextView) findViewById(R.id.demotionPoints);

        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new Ranking_ImageListAdapter(this));

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    promotionPoints.setText(Long.toString(points[listView.getFirstVisiblePosition()]));
                    demotionPoints.setText(Long.toString(points[listView.getFirstVisiblePosition()]));
               }
            }
        });

    }
}

