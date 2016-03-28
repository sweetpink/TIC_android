package com.example.henrik.facebook_test_rightversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ComboCreatorViewCombo extends AppCompatActivity{
    ArrayList<String> inputArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combocreator_view);

        loadCombo();

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.combocreator_tabmovelist_item, inputArray);

        final ListView listView = (ListView) findViewById(R.id.combolist);
        listView.setAdapter(adapter);

    }




    private void loadCombo(){
        inputArray = new ArrayList<>();

        try {
            FileInputStream in = openFileInput("char");

            InputStreamReader inputStreamReader = new InputStreamReader(in);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //StringBuilder sb = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                inputArray.add(line);

            }
        }catch(IOException ex){

        }
    }
}



