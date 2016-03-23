package com.example.henrik.facebook_test_rightversion;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        alarmChecker();
    }



    public void frameDataButton(View view){
        Intent intent = new Intent(MainMenu.this, FrameDataMenu.class);   //Lägg till rätt namn för frameData Klassen
        startActivity(intent);
    }

    public void rankingButton(View view){
        Intent intent = new Intent(MainMenu.this, Ranking.class);     //Lägg till rätt namn för Rankings Klassen

        startActivity(intent);
    }

    public void comboCreatorButton(View view){
        /*Intent intent = new Intent(MainMenu.this, ComboCreator.class);     //Lägg till rätt namn för ComboCreator Klassen
        startActivity(intent);*/
    }

    public void tutorialsButton(View view){
        Intent intent = new Intent(MainMenu.this, Tutorials.class);     //Lägg till rätt namn för Tutorials Klassen
        startActivity(intent);
    }

    public void sitesButton(View view){
        Intent intent = new Intent(MainMenu.this, Sites.class);     //Lägg till rätt namn för sites Klassen
        startActivity(intent);
    }

    public void tournamentButton(View view){
        Intent intent = new Intent(MainMenu.this, Tournament.class);     //Lägg till rätt namn för changelogg Klassen
        startActivity(intent);
    }

    public void facebookButton(View view){
        /*Intent intent = new Intent(MainMenu.this, Facebook.class);     //Lägg till rätt namn för changelogg Klassen
        startActivity(intent);*/

        Facebook_Fragment fragment = new Facebook_Fragment();
        createYourFragment(fragment);


    }

    public void youtubeButton(View view){

    }

    public void twitterButton(View view){

    }

    public void patreonButton(View view){

    }
    private void createYourFragment(Fragment fragmentName) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main, fragmentName);
        transaction.commit();
    }
    private void alarmChecker(){    //Ska ligga i main menu eftersom den ska startas när appen startar!!!!
        Log.d("432", "AlarmChecker");
        Intent notifyIntent = new Intent(MainMenu.this, ReciverNotification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 5, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);//sista kan va 0
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(alarmManager.RTC_WAKEUP, System.currentTimeMillis(), alarmManager.INTERVAL_DAY, pendingIntent);//alarmManager.INTERVAL_DAY nästsista parameter. Byt till valfrit om testa alarm
        Log.d("432", "AlarmChecker");
    }


}

