package com.example.henrik.facebook_test_rightversion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class FrameDataMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_data_menu);
    }

    public void frameDataPressed(View view){
        Intent intent = new Intent(FrameDataMenu.this, MovelistViewer.class);
        startActivity(intent);
    }

    public void punishmentPressed(View view){
        Intent intent = new Intent(FrameDataMenu.this, PunishmentViewer.class);
        startActivity(intent);
    }

}
