package com.example.henrik.facebook_test_rightversion;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ComboCreator extends TabActivity {

    TabHost tabHost;
    static TextView chosenComboTV;
    EditText damageET;
    static String playerCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_creator);

        createFragment();


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

    private void createFragment(){
        CharacterSelection fragCharSelect = new CharacterSelection();
        Bundle sendString = new Bundle();

        sendString.putString("imagePressed", "combocreator");

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        fragCharSelect.setArguments(sendString);
        transaction.replace(R.id.mainContainer, fragCharSelect);
        transaction.addToBackStack("fragAbout to backstack");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        transaction.commit();
    }

    public void setPlayerCharacter(String character){
        playerCharacter = character;
    }

    public static String getPlayerCharacter(){
        return playerCharacter;

    }
    public void createTabs() {
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

        buttonsVisable();



    }

    private void buttonsVisable(){
        Button save = (Button) findViewById(R.id.saveButton);
        Button view = (Button) findViewById(R.id.viewButton);

        save.setVisibility(View.VISIBLE);
        save.setEnabled(true);

        view.setVisibility(View.VISIBLE);
        view.setEnabled(true);
    }


}
