package com.example.henrik.facebook_test_rightversion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Sites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sites);

        ImageButton site = (ImageButton) findViewById(R.id.siteButton);
        ImageButton site2 = (ImageButton) findViewById(R.id.siteButton2);
        ImageButton site3 = (ImageButton) findViewById(R.id.siteButton3);
        ImageButton site4 = (ImageButton) findViewById(R.id.siteButton4);
        ImageButton site5 = (ImageButton) findViewById(R.id.siteButton5);
        ImageButton site6 = (ImageButton) findViewById(R.id.siteButton6);
        ImageButton site7 = (ImageButton) findViewById(R.id.siteButton7);
        ImageButton site8 = (ImageButton) findViewById(R.id.siteButton8);

        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.tekkenzaibatsu.com/"));

                startActivity(i);
            }
        });

        site2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://rbnorway.org/"));

                startActivity(i);
            }
        });


        site3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://tekkendb.com/"));

                startActivity(i);
            }
        });


        site4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.avoidingthepuddle.com/"));

                startActivity(i);
            }
        });


        site5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.levelupyourgame.com/"));

                startActivity(i);
            }
        });


        site6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://twitter.com/flying_wonkey"));

                startActivity(i);
            }
        });


        site7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://twitter.com/harada_tekken"));

                startActivity(i);
            }
        });


        site8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.twitch.tv/Tekken"));

                startActivity(i);
            }
        });

    }
}
