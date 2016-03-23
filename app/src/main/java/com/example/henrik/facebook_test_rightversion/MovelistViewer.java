package com.example.henrik.facebook_test_rightversion;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MovelistViewer extends AppCompatActivity {
    private List<String> mLines = new ArrayList<>();
    private TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
    private ArrayList<Move> playerMovelist = new ArrayList<>();
    private CheckBox normalMoves;
    private CheckBox pokesMoves;
    private CheckBox goodMoves;
    private CheckBox launchers;
    private CheckBox grabs;
    private CheckBox tailspins;
    private String playerCharacter;
    TableRow[] tableRows;
    TableLayout secondaryTable;
    int color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movelist_viewer);

        normalMoves = (CheckBox) findViewById(R.id.normalBox);
        pokesMoves = (CheckBox) findViewById(R.id.pokesBox);
        goodMoves = (CheckBox) findViewById(R.id.goodBox);
        launchers = (CheckBox) findViewById(R.id.launchersBox);
        grabs  = (CheckBox) findViewById(R.id.grabsBox);
        tailspins = (CheckBox) findViewById(R.id.tailspinsBox);

        createTableHeaders();
        setPlayerCharacter("kazuya");
    }

    public void setPlayerCharacter(String selectedCharacter){
        playerCharacter = selectedCharacter;
        playerMovelist.clear();
        readFile(playerCharacter);

        for(int i = 0; i < mLines.size(); i+=10){
            playerMovelist.add(new Move("", mLines.get(i), mLines.get(i + 1), mLines.get(i + 2), mLines.get(i + 3), mLines.get(i + 4), mLines.get(i + 5), mLines.get(i + 6), mLines.get(i + 7), mLines.get(i + 8)));
        }

        mLines.clear();
        createTableRows();
    }

    private void createTableHeaders(){
        TableLayout primaryTable = (TableLayout) findViewById(R.id.columnLayout);
        TableRow columns = new TableRow(this);

        TextView columnCommand = new TextView(this);
        columnCommand.setLayoutParams(lp);
        columnCommand.setTextColor(Color.WHITE);
        columnCommand.setText("Command");
        columnCommand.setWidth(500);

        TextView columnHitLevel = new TextView(this);
        columnHitLevel.setLayoutParams(lp);
        columnHitLevel.setTextColor(Color.WHITE);
        columnHitLevel.setText("Hit Level");
        columnHitLevel.setPadding(30, 0, 0, 0);
        columnHitLevel.setWidth(400);

        TextView columnDamage = new TextView(this);
        columnDamage.setLayoutParams(lp);
        columnDamage.setTextColor(Color.WHITE);
        columnDamage.setText("Damage");
        columnDamage.setPadding(30, 0, 0, 0);
        columnDamage.setWidth(400);

        TextView columnStartUpFrame = new TextView(this);
        columnStartUpFrame.setLayoutParams(lp);
        columnStartUpFrame.setTextColor(Color.WHITE);
        columnStartUpFrame.setText("Start up Frame");
        columnStartUpFrame.setPadding(30, 0, 0, 0);
        columnStartUpFrame.setWidth(400);

        TextView columnBlockFrame = new TextView(this);
        columnBlockFrame.setLayoutParams(lp);
        columnBlockFrame.setTextColor(Color.WHITE);
        columnBlockFrame.setText("Block Frame");
        columnBlockFrame.setPadding(30, 0, 0, 0);
        columnBlockFrame.setWidth(400);

        TextView columnHitFrame = new TextView(this);
        columnHitFrame.setLayoutParams(lp);
        columnHitFrame.setTextColor(Color.WHITE);
        columnHitFrame.setText("Hit Frame");
        columnHitFrame.setPadding(30, 0, 0, 0);
        columnHitFrame.setWidth(400);

        TextView columnCounterHitFrame = new TextView(this);
        columnCounterHitFrame.setLayoutParams(lp);
        columnCounterHitFrame.setTextColor(Color.WHITE);
        columnCounterHitFrame.setText("Counter hit Frame");
        columnCounterHitFrame.setPadding(30, 0, 0, 0);
        columnCounterHitFrame.setWidth(400);

        columns.addView(columnCommand);
        columns.addView(columnHitLevel);
        columns.addView(columnDamage);
        columns.addView(columnStartUpFrame);
        columns.addView(columnBlockFrame);
        columns.addView(columnHitFrame);
        columns.addView(columnCounterHitFrame);

        primaryTable.addView(columns, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    public void createTableRows(){
        secondaryTable = (TableLayout) findViewById(R.id.rowLayout);
        secondaryTable.removeAllViews();
        tableRows = new TableRow[playerMovelist.size()];

        int counter = 0;
        color = 0;

        for(int i = 0; i < playerMovelist.size(); i++) {
            if ((counter % 2) == 0) {
                // number is even
                color = Color.parseColor("#801C1C1C");
            }

            else{
                // number is odd
                color = Color.parseColor("#800F0F0F");
            }

            if(normalMoves.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Normal")){
                tableRowDesigner(i);
                counter++;
            }
            else if(pokesMoves.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Poke")){
                tableRowDesigner(i);
                counter++;
            }
            else if(goodMoves.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("GoodMove")){
                tableRowDesigner(i);
                counter++;
            }
            else if(launchers.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Launcher")){
                tableRowDesigner(i);
                counter++;
            }
            else if(tailspins.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Tailspin")){
                tableRowDesigner(i);
                counter++;
            }
            else if(grabs.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Grab")){
                tableRowDesigner(i);
                counter++;
            }
        }

    }

    private void tableRowDesigner(Integer index){
        tableRows[index] = new TableRow(this);
        tableRows[index].setLayoutParams(lp);

        tableRows[index].setBackgroundColor(color);

        TextView command = new TextView(this);
        command.setLayoutParams(lp);
        command.setTextColor(Color.WHITE);
        command.setText(playerMovelist.get(index).getCommand());
        command.setWidth(500);

        TextView hitLevel = new TextView(this);
        hitLevel.setLayoutParams(lp);
        hitLevel.setTextColor(Color.WHITE);
        hitLevel.setText(playerMovelist.get(index).getHitLevel());
        hitLevel.setPadding(30, 0, 0, 0);
        hitLevel.setWidth(400);

        TextView damage = new TextView(this);
        damage.setLayoutParams(lp);
        damage.setTextColor(Color.WHITE);
        damage.setText(playerMovelist.get(index).getDamage());
        damage.setPadding(30, 0, 0, 0);
        damage.setWidth(400);

        TextView startUpFrame = new TextView(this);
        startUpFrame.setLayoutParams(lp);
        startUpFrame.setTextColor(Color.WHITE);
        startUpFrame.setText(playerMovelist.get(index).getStartUpFrame());
        startUpFrame.setPadding(30, 0, 0, 0);
        startUpFrame.setWidth(400);

        TextView blockFrame = new TextView(this);
        blockFrame.setLayoutParams(lp);
        blockFrame.setTextColor(Color.WHITE);
        blockFrame.setText(playerMovelist.get(index).getBlockFrame());
        blockFrame.setPadding(30, 0, 0, 0);
        blockFrame.setWidth(400);

        TextView hitFrame = new TextView(this);
        hitFrame.setLayoutParams(lp);
        hitFrame.setTextColor(Color.WHITE);
        hitFrame.setText(playerMovelist.get(index).getHitFrame());
        hitFrame.setPadding(30, 0, 0, 0);
        hitFrame.setWidth(400);

        TextView counterHitFrame = new TextView(this);
        counterHitFrame.setLayoutParams(lp);
        counterHitFrame.setTextColor(Color.WHITE);
        counterHitFrame.setText(playerMovelist.get(index).getCounterHitFrame());
        counterHitFrame.setPadding(30, 0, 0, 0);
        counterHitFrame.setWidth(400);

        tableRows[index].addView(command);
        tableRows[index].addView(hitLevel);
        tableRows[index].addView(damage);
        tableRows[index].addView(startUpFrame);
        tableRows[index].addView(blockFrame);
        tableRows[index].addView(hitFrame);
        tableRows[index].addView(counterHitFrame);

        secondaryTable.addView(tableRows[index], new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkBoxClicked(View view){
        secondaryTable = (TableLayout) findViewById(R.id.rowLayout);
        secondaryTable.removeAllViews();
        tableRows = new TableRow[playerMovelist.size()];

        int counter = 0;
        color = 0;

        for(int i = 0; i < playerMovelist.size(); i++) {
            if ((counter % 2) == 0) {
                // number is even
                color = Color.parseColor("#801C1C1C");
            }

            else{
                // number is odd
                color = Color.parseColor("#800F0F0F");
            }

            if(normalMoves.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Normal")){
                tableRowDesigner(i);
                counter++;
            }
            else if(pokesMoves.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Poke")){
                tableRowDesigner(i);
                counter++;
            }
            else if(goodMoves.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("GoodMove")){
                tableRowDesigner(i);
                counter++;
            }
            else if(launchers.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Launcher")){
                tableRowDesigner(i);
                counter++;
            }
            else if(tailspins.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Tailspin")){
                tableRowDesigner(i);
                counter++;
            }
            else if(grabs.isChecked() && playerMovelist.get(i).getPrimaryAttr().equals("Grab")){
                tableRowDesigner(i);
                counter++;
            }
        }
    }
}

