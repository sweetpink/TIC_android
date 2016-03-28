package com.example.henrik.facebook_test_rightversion;

import android.support.v7.app.AppCompatActivity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sweetpink on 2016-03-25.
 */
public class ComboCreator_TabMoveList extends AppCompatActivity {

    List<String> mLines = new ArrayList<>();
    ArrayList<Move> chosenCharMoveList = new ArrayList<>();
    String selectedFromList;
    String playermadeCombo = "";
    String playerCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combocreator_tabmovelist);

        ArrayList<String> moveList = new ArrayList<>();

        readFile(ComboCreator.getPlayerCharacter());

        for(int i = 0; i < chosenCharMoveList.size(); i++){
            moveList.add(chosenCharMoveList.get(i).getCommand());
        }


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.combocreator_tabmovelist_item, moveList);

        final ListView listView = (ListView) findViewById(R.id.movelist);
        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                selectedFromList =(String) (listView.getItemAtPosition(myItemInt));
                updateComboShower(selectedFromList);

            }
        });

    }

    private void readFile(String fileName){
        AssetManager am = getAssets();
        String filePath = "Movelists/" + fileName + ".txt";

        try {
            InputStream is = am.open(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                mLines.add(line);

        }catch (IOException e){
            e.printStackTrace();
        }

        for(int i = 0; i < mLines.size(); i+= 10){
            chosenCharMoveList.add(new Move("", mLines.get(i), mLines.get(i + 1), mLines.get(i + 2), mLines.get(i + 3), mLines.get(i + 4), mLines.get(i + 5), mLines.get(i + 6), mLines.get(i + 7), mLines.get(i + 8)));
        }

    }


    private void updateComboShower(String addedMove){
        playermadeCombo = ComboCreator.getChosenComboTV();
        playermadeCombo += " , " + addedMove;
        ComboCreator.setchosenComboTV(playermadeCombo);

    }

    public void setPlayerCharacter(String selectedCharacter) {
        playerCharacter = selectedCharacter;

        readFile(playerCharacter);
    }

}
