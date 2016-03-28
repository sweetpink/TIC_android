package com.example.henrik.facebook_test_rightversion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReciverNotification extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("OnRecive", "Recived Alarm updater");
       checkIfTimeToNotify(context);
    }

    private void createNotify(String tournamentName, Context context) {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
        notificationBuilder.setContentTitle("En turnering startar om 24 timmar!");
        notificationBuilder.setContentText("Dags för:    " + tournamentName);

        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);

        //Kod för att kunna öppna activity vid notification click.
        int notifyID = 1;
        Intent notificationIntent = new Intent(context, Tournament.class);
        PendingIntent intent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(intent);

        NotificationManager notificationHandler = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationHandler.notify(notifyID, notificationBuilder.build());
        notificationBuilder.setAutoCancel(true);
    }

    private void checkIfTimeToNotify(Context context) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();

        SharedPreferences preferencesGetter = PreferenceManager.getDefaultSharedPreferences(context);
        Log.d("Tour Date", preferencesGetter.getString("Tour1Date", "default"));
        if(preferencesGetter.getString("Tour1Date","0000-00-00").equals(dateFormat.format(currentDate))) {  //Ändra från dateformat till samma datum som turneringen för att visa upp notification.
            createNotify(preferencesGetter.getString("Tour1Name","DefaultName"),context);
        }
    }

}


