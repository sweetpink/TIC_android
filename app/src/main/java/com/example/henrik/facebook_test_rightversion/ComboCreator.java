package com.example.henrik.facebook_test_rightversion;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

/**
 * Created by Sweetpink on 2016-03-25.
 */
public class ComboCreator extends TabActivity {

    TabHost tabHost;
    static TextView chosenComboTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_creator);

        chosenComboTV = (TextView) findViewById(R.id.chosenComboTextView);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabSpec tabMoveList = tabHost.newTabSpec("MoveList");
        TabSpec tabTailSpins = tabHost.newTabSpec("Tailspins");
        TabSpec tabOther = tabHost.newTabSpec("Other");

        tabMoveList.setIndicator("MoveList");
        tabMoveList.setContent(new Intent(this, ComboCreator_TabMoveList.class));

        tabHost.addTab(tabMoveList);

    }

    public static void setchosenComboTV(String stringToDisplay){
        chosenComboTV.setText(stringToDisplay);
    }


}
