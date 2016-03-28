package com.example.henrik.facebook_test_rightversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Sweetpink on 2016-03-26.
 */
public class ComboCreator_TabOther extends AppCompatActivity{


    String[] otherList = {"W!", "FB!", "SSR","SSL", "LP", "CH"};
    String playermadeCombo = "";
    String selectedFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combocreator_tabmovelist);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.combocreator_tabmovelist_item, otherList);

        final ListView listView = (ListView) findViewById(R.id.movelist);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                selectedFromList = (String) (listView.getItemAtPosition(myItemInt));
                updateComboShower(selectedFromList);

            }
        });
    }


    private void updateComboShower(String addedMove){
        playermadeCombo = ComboCreator.getChosenComboTV();
        playermadeCombo += " + " + addedMove;
        ComboCreator.setchosenComboTV(playermadeCombo);

    }


    //W!, FB!, SSR,SSL, LP, CH


}
