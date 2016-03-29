package com.example.henrik.facebook_test_rightversion;

//--------------------------------------------ANDROID IMPORTS-------------------------------------\\
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

//-----------------------------------------JAVA IMPORTS-------------------------------------------\\
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PunishmentViewer extends AppCompatActivity {
//---------------------------------------LAYOUT VARIABLES-----------------------------------------\\
    private LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

    private Spinner frameSelector;

    private CheckBox specificBox;

    private TextView punishDisplay;
    private TextView punishersAre;

    private ImageView playerPortrait;
    private ImageView opponentPortrait;
//--------------------------------------REGULAR VARIABLES-----------------------------------------\\
    private String playerCharacter = "";
    private String opponentCharacter = "";

    private List<String> mLines = new ArrayList<>();
    private ArrayList<String> playerPunishList = new ArrayList<>();
    private ArrayList<Move> opponentMovelist = new ArrayList<>();

    private boolean firstBoot = true;
//------------------------------------------ON START-UP-------------------------------------------\\
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punishment_viewer);

        createFragment("player");

        String[] arraySpinner = new String[] {"-10", "-11", "-12", "-13", "-14", "-15", "-16", "-17"};
        frameSelector = (Spinner) findViewById(R.id.frameSelector);

        frameSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if(!firstBoot) {
                    createTableRows();
                    refreshPunishers(frameSelector.getSelectedItemPosition());
                }

                firstBoot = false;
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        specificBox = (CheckBox) findViewById(R.id.specificBox);

        specificBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createTableRows();
            }
        });
        punishDisplay = (TextView) findViewById(R.id.punishDisplay);
        punishersAre = (TextView) findViewById(R.id.punishersAre);
        opponentPortrait = (ImageView) findViewById(R.id.opponentPortrait);
        playerPortrait = (ImageView) findViewById(R.id.playerPortrait);

        createTableHeaders();

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.custom_spinner, arraySpinner);
        frameSelector.setAdapter(listAdapter);

    }

//---------------------------------------PRIVATE METHODS------------------------------------------\\
    private void createFragment(String stringIdentifier){
        CharacterSelection fragCharSelect = new CharacterSelection();
        Bundle sendString = new Bundle();

        sendString.putString("imagePressed", stringIdentifier);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        fragCharSelect.setArguments(sendString);
        transaction.replace(R.id.mainContainer, fragCharSelect);
        transaction.addToBackStack("fragAbout to backstack");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        transaction.commit();
    }

    private void readFile(String fileName){
        AssetManager am = getAssets();
        String filePath = fileName + ".txt";
        mLines.clear();

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

    private void createTableHeaders(){
        TableLayout primaryTable = (TableLayout) findViewById(R.id.columnLayout);
        TableRow columns = new TableRow(this);

        TextView columnCommand = new TextView(this);
        columnCommand.setLayoutParams(lp);
        columnCommand.setText("Command");
        columnCommand.setWidth(500);
        columnCommand.setTextColor(Color.parseColor("#D9D9D9"));
        columnCommand.setTextSize(16);
        columnCommand.setBackgroundColor(Color.parseColor("#800A0A0A"));

        TextView columnHitLevel = new TextView(this);
        columnHitLevel.setLayoutParams(lp);
        columnHitLevel.setText("Hit Level");
        columnHitLevel.setPadding(30, 0, 0, 0);
        columnHitLevel.setWidth(400);
        columnHitLevel.setTextColor(Color.parseColor("#D9D9D9"));
        columnHitLevel.setTextSize(16);
        columnHitLevel.setBackgroundColor(Color.parseColor("#800A0A0A"));

        TextView columnDamage = new TextView(this);
        columnDamage.setLayoutParams(lp);
        columnDamage.setText("Damage");
        columnDamage.setPadding(30, 0, 0, 0);
        columnDamage.setWidth(400);
        columnDamage.setTextColor(Color.parseColor("#D9D9D9"));
        columnDamage.setTextSize(16);
        columnDamage.setBackgroundColor(Color.parseColor("#800A0A0A"));

        TextView columnStartUpFrame = new TextView(this);
        columnStartUpFrame.setLayoutParams(lp);
        columnStartUpFrame.setText("Start up Frame");
        columnStartUpFrame.setPadding(30, 0, 0, 0);
        columnStartUpFrame.setWidth(400);
        columnStartUpFrame.setTextColor(Color.parseColor("#D9D9D9"));
        columnStartUpFrame.setTextSize(16);
        columnStartUpFrame.setBackgroundColor(Color.parseColor("#800A0A0A"));

        TextView columnBlockFrame = new TextView(this);
        columnBlockFrame.setLayoutParams(lp);
        columnBlockFrame.setText("Block Frame");
        columnBlockFrame.setPadding(30, 0, 0, 0);
        columnBlockFrame.setWidth(400);
        columnBlockFrame.setTextColor(Color.parseColor("#D9D9D9"));
        columnBlockFrame.setTextSize(16);
        columnBlockFrame.setBackgroundColor(Color.parseColor("#800A0A0A"));

        TextView columnHitFrame = new TextView(this);
        columnHitFrame.setLayoutParams(lp);
        columnHitFrame.setText("Hit Frame");
        columnHitFrame.setPadding(30, 0, 0, 0);
        columnHitFrame.setWidth(400);
        columnHitFrame.setTextColor(Color.parseColor("#D9D9D9"));
        columnHitFrame.setTextSize(16);
        columnHitFrame.setBackgroundColor(Color.parseColor("#800A0A0A"));

        TextView columnCounterHitFrame = new TextView(this);
        columnCounterHitFrame.setLayoutParams(lp);
        columnCounterHitFrame.setText("Counter hit Frame");
        columnCounterHitFrame.setPadding(30, 0, 0, 0);
        columnCounterHitFrame.setWidth(450);
        columnCounterHitFrame.setTextColor(Color.parseColor("#D9D9D9"));
        columnCounterHitFrame.setTextSize(16);
        columnCounterHitFrame.setBackgroundColor(Color.parseColor("#800A0A0A"));

        columns.addView(columnCommand);
        columns.addView(columnHitLevel);
        columns.addView(columnDamage);
        columns.addView(columnStartUpFrame);
        columns.addView(columnBlockFrame);
        columns.addView(columnHitFrame);
        columns.addView(columnCounterHitFrame);

        primaryTable.addView(columns, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

    private void createTableRows(){
        TableLayout secondaryTable = (TableLayout) findViewById(R.id.rowLayout);
        secondaryTable.removeAllViews();
        TableRow[] tableRows = new TableRow[opponentMovelist.size()];
        int counter = 0;
        int color;

        for(int i = 0; i < opponentMovelist.size(); i++) {
            if ((counter % 2) == 0) {
                // number is even
                color = Color.parseColor("#801C1C1C");
            }

            else{
                // number is odd
                color = Color.parseColor("#800F0F0F");
            }

            if (!specificBox.isChecked()) {
                if (Integer.parseInt(opponentMovelist.get(i).getBlockFrame()) <= Integer.parseInt(frameSelector.getSelectedItem().toString())) {
                    tableRows[i] = new TableRow(this);
                    tableRows[i].setLayoutParams(lp);

                    tableRows[i].setBackgroundColor(color);

                    TextView command = new TextView(this);
                    command.setLayoutParams(lp);
                    command.setTextColor(Color.parseColor("#D9D9D9"));
                    command.setText(opponentMovelist.get(i).getCommand());
                    command.setWidth(500);

                    TextView hitLevel = new TextView(this);
                    hitLevel.setLayoutParams(lp);
                    hitLevel.setTextColor(Color.parseColor("#D9D9D9"));
                    hitLevel.setText(opponentMovelist.get(i).getHitLevel());
                    hitLevel.setPadding(30, 0, 0, 0);
                    hitLevel.setWidth(400);

                    TextView damage = new TextView(this);
                    damage.setLayoutParams(lp);
                    damage.setTextColor(Color.parseColor("#D9D9D9"));
                    damage.setText(opponentMovelist.get(i).getDamage());
                    damage.setPadding(30, 0, 0, 0);
                    damage.setWidth(400);

                    TextView startUpFrame = new TextView(this);
                    startUpFrame.setLayoutParams(lp);
                    startUpFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    startUpFrame.setText(opponentMovelist.get(i).getStartUpFrame());
                    startUpFrame.setPadding(30, 0, 0, 0);
                    startUpFrame.setWidth(400);

                    TextView blockFrame = new TextView(this);
                    blockFrame.setLayoutParams(lp);
                    blockFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    blockFrame.setText(opponentMovelist.get(i).getDisplayBlockFrame());
                    blockFrame.setPadding(30, 0, 0, 0);
                    blockFrame.setWidth(400);

                    TextView hitFrame = new TextView(this);
                    hitFrame.setLayoutParams(lp);
                    hitFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    hitFrame.setText(opponentMovelist.get(i).getHitFrame());
                    hitFrame.setPadding(30, 0, 0, 0);
                    hitFrame.setWidth(400);

                    TextView counterHitFrame = new TextView(this);
                    counterHitFrame.setLayoutParams(lp);
                    counterHitFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    counterHitFrame.setText(opponentMovelist.get(i).getCounterHitFrame());
                    counterHitFrame.setPadding(30, 0, 0, 0);
                    counterHitFrame.setWidth(450);

                    tableRows[i].addView(command);
                    tableRows[i].addView(hitLevel);
                    tableRows[i].addView(damage);
                    tableRows[i].addView(startUpFrame);
                    tableRows[i].addView(blockFrame);
                    tableRows[i].addView(hitFrame);
                    tableRows[i].addView(counterHitFrame);

                    secondaryTable.addView(tableRows[i], new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                    counter++;
                }
            }
            else if(specificBox.isChecked()){
                if (Integer.parseInt(opponentMovelist.get(i).getBlockFrame()) == Integer.parseInt(frameSelector.getSelectedItem().toString())) {
                    tableRows[i] = new TableRow(this);
                    tableRows[i].setLayoutParams(lp);
                    tableRows[i].setBackgroundColor(color);

                    TextView command = new TextView(this);
                    command.setLayoutParams(lp);
                    command.setTextColor(Color.parseColor("#D9D9D9"));
                    command.setText(opponentMovelist.get(i).getCommand());
                    command.setWidth(500);

                    TextView hitLevel = new TextView(this);
                    hitLevel.setLayoutParams(lp);
                    hitLevel.setTextColor(Color.parseColor("#D9D9D9"));
                    hitLevel.setText(opponentMovelist.get(i).getHitLevel());
                    hitLevel.setPadding(30, 0, 0, 0);
                    hitLevel.setWidth(400);

                    TextView damage = new TextView(this);
                    damage.setLayoutParams(lp);
                    damage.setTextColor(Color.parseColor("#D9D9D9"));
                    damage.setText(opponentMovelist.get(i).getDamage());
                    damage.setPadding(30, 0, 0, 0);
                    damage.setWidth(400);

                    TextView startUpFrame = new TextView(this);
                    startUpFrame.setLayoutParams(lp);
                    startUpFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    startUpFrame.setText(opponentMovelist.get(i).getStartUpFrame());
                    startUpFrame.setPadding(30, 0, 0, 0);
                    startUpFrame.setWidth(400);

                    TextView blockFrame = new TextView(this);
                    blockFrame.setLayoutParams(lp);
                    blockFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    blockFrame.setText(opponentMovelist.get(i).getDisplayBlockFrame());
                    blockFrame.setPadding(30, 0, 0, 0);
                    blockFrame.setWidth(400);

                    TextView hitFrame = new TextView(this);
                    hitFrame.setLayoutParams(lp);
                    hitFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    hitFrame.setText(opponentMovelist.get(i).getHitFrame());
                    hitFrame.setPadding(30, 0, 0, 0);
                    hitFrame.setWidth(400);

                    TextView counterHitFrame = new TextView(this);
                    counterHitFrame.setLayoutParams(lp);
                    counterHitFrame.setTextColor(Color.parseColor("#D9D9D9"));
                    counterHitFrame.setText(opponentMovelist.get(i).getCounterHitFrame());
                    counterHitFrame.setPadding(30, 0, 0, 0);
                    counterHitFrame.setWidth(450);

                    tableRows[i].addView(command);
                    tableRows[i].addView(hitLevel);
                    tableRows[i].addView(damage);
                    tableRows[i].addView(startUpFrame);
                    tableRows[i].addView(blockFrame);
                    tableRows[i].addView(hitFrame);
                    tableRows[i].addView(counterHitFrame);

                    secondaryTable.addView(tableRows[i], new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                    counter++;
                }
            }
        }

    }

    private void refreshPunishers(int id){
        String replacementString = playerPunishList.get(id).replaceAll("crlf", "\r\n");


        punishDisplay.setText(replacementString);


        punishersAre.setVisibility(View.VISIBLE);

    }

//-------------------------------------PUBLIC METHODS---------------------------------------------\\
    public void playerPortraitClicked(View view){
        String imagePressed = "player";
        createFragment(imagePressed);
    }

    public void opponentPortraitClicked(View view){
        String imagePressed = "opponent";
        createFragment(imagePressed);
    }

    public void setPlayerCharacter(String selectedPlayer){
        playerCharacter = selectedPlayer;
        readFile("Punishers/" + playerCharacter);

        playerPunishList.clear();
        for(int i = 0; i < mLines.size(); i++) {
            playerPunishList.add(mLines.get(i));
        }

        specificBox.setVisibility(View.VISIBLE);
        frameSelector.setVisibility(View.VISIBLE);
        playerPortrait.setVisibility(View.VISIBLE);
        opponentPortrait.setVisibility(View.VISIBLE);

        refreshPunishers(frameSelector.getSelectedItemPosition());
    }

    public void setOpponentCharacter(String selectedOpponent){
        opponentCharacter = selectedOpponent;

        opponentMovelist.clear();
        readFile("Movelists/" + opponentCharacter);

        for(int i = 0; i < mLines.size(); i+=10){
            opponentMovelist.add(new Move("", mLines.get(i), mLines.get(i + 1), mLines.get(i + 2), mLines.get(i + 3), mLines.get(i + 4), mLines.get(i + 5), mLines.get(i + 6), mLines.get(i + 7), mLines.get(i + 8)));
        }

        createTableRows();
    }

}
