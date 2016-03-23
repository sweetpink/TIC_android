package com.example.henrik.facebook_test_rightversion;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

/**
 * Created by Henrik on 2016-03-24.
 */

public class Tournament extends AppCompatActivity {
    private static Context contextOfApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        contextOfApplication = getApplicationContext();
        Log.d("sad", "sven");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tournament_layout);

        //createNotify("testname");   //Ta bort senare bara för att testa notify
        try {
            createTournamentList();
            final ImageView backgroundImage = (ImageView) findViewById(R.id.imageViewTest);
            Picasso.with(this.getApplicationContext()).load("https://hypefinder.com/webroot/img.php?src=finalround.png&sharpen&width=50&").into(backgroundImage); //För testaloggan ta bort

        } catch (Exception e) {
            e.printStackTrace();
            Log.w("asd", "kunde inte läsa in");
        }
    }
    private void createTournamentList(){
        ListView listOptions = (ListView) findViewById(R.id.tournamentList2);
        new JsoupGetter(listOptions,this).execute();
    }


    public static Context getContextOfApplication(){
        return contextOfApplication;
    }



}


