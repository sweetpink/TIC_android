package com.example.henrik.facebook_test_rightversion;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Sweetpink on 2016-03-25.
 */
public class ComboCreator extends TabActivity {

    TabHost tabHost;
    static TextView chosenComboTV;
    EditText damageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_creator);

        chosenComboTV = (TextView) findViewById(R.id.chosenComboTextView);
        damageET = (EditText) findViewById(R.id.damageET);
        tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabSpec tabMoveList = tabHost.newTabSpec("MoveList");
        TabSpec tabTailSpins = tabHost.newTabSpec("Tailspins");
        TabSpec tabOther = tabHost.newTabSpec("Other");

        tabMoveList.setIndicator("Moves");
        tabMoveList.setContent(new Intent(this, ComboCreator_TabMoveList.class));

        tabOther.setIndicator("Tailspins");
        tabOther.setContent(new Intent(this, ComboCreator_TabTailspin.class));

        tabTailSpins.setIndicator("Other");
        tabTailSpins.setContent(new Intent(this, ComboCreator_TabOther.class));


        tabHost.addTab(tabMoveList);
        tabHost.addTab(tabTailSpins);
        tabHost.addTab(tabOther);

        System.out.println("ta bort denna sen");

    }

    public static void setchosenComboTV(String stringToDisplay){
        chosenComboTV.setText(stringToDisplay);
    }

    public static String getChosenComboTV(){
        return chosenComboTV.getText().toString();
    }


    private void saveCombo() throws FileNotFoundException {
        String comboToSave = (chosenComboTV.getText().toString()) + " DMG: " +damageET.getText() + "\n";
        String filename = "char";
        FileOutputStream fos;

        try {

            if(fileExistance(filename) == false) {
                fos = openFileOutput(filename, Context.MODE_PRIVATE);
                fos.write(comboToSave.getBytes());
            }else{
                fos = openFileOutput(filename, Context.MODE_APPEND);
                fos.write(comboToSave.getBytes());
            }

            fos.close();

        }catch(IOException ex){

        }
    }

    public void viewButton(View view){
        Intent intent = new Intent(ComboCreator.this, ComboCreatorViewCombo.class);
        startActivity(intent);
    }

    public void saveButton(View view) throws FileNotFoundException {
        saveCombo();
    }

    public boolean fileExistance(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }



}
