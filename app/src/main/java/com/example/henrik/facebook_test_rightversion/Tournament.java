package com.example.henrik.facebook_test_rightversion;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;


public class Tournament extends AppCompatActivity {
    private static Context contextOfApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        contextOfApplication = getApplicationContext();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tournament_layout);


        try {
            createTournamentList();

        } catch (Exception e) {
            e.printStackTrace();
            Log.w("Tour23", "kunde inte läsa in");
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


