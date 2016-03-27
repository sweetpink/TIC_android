package com.example.henrik.facebook_test_rightversion;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henrik on 2016-03-24.
 */
public class JsoupGetter extends AsyncTask<Object, Void,List<String>> {

    private ArrayList<String> flagIconArray = new ArrayList<>();
    private ArrayList<String> logoIconArray = new ArrayList<>();
    private ArrayList<String> nameArray = new ArrayList<>();
    private ArrayList<String> dateArray = new ArrayList<>();
    private ArrayList<String> linksOnClickarray = new ArrayList<>();

    private ListView itcItems;
    private Activity local;

    private String urlLinkTournamentSite = "https://hypefinder.com/webroot/index.php?orderby=start_date&order=asc&genre=Tekken+Tag+Tournament+2";

    public JsoupGetter(ListView lv, Activity activity){
        this.itcItems = lv;
        this.local = activity;
    }
    @Override
    protected void onPostExecute(List<String> result) {

        Log.d("flagIconArray", String.valueOf(flagIconArray.size()));
        Log.d("logoIconArray", String.valueOf(logoIconArray.size()));
        Log.d("nameArray", String.valueOf(nameArray.size()));
        Log.d("dateArray", String.valueOf(dateArray.size()));

        itcItems.setAdapter(new Tournament_ImageListAdapter(local, flagIconArray, logoIconArray, nameArray, dateArray)); //flag,logo,name,date
        itcItems.setOnItemClickListener(new ListListener(local, linksOnClickarray));

        saveIntoSharedPreferences();

        Log.d("Watch this", String.valueOf(linksOnClickarray.size()));
    }
    private void saveIntoSharedPreferences(){
        Context applicationContext = Tournament.getContextOfApplication();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        SharedPreferences.Editor prefEditor = preferences.edit();
        prefEditor.putString("Tour1Name",nameArray.get(0));
        prefEditor.putString("Tour1Date", dateArray.get(0));
        prefEditor.commit();
    }

    @Override
    protected  List<String> doInBackground(Object[] objects) {
        try {
            getTableInfoFromWeb();
            getImageNames();
            getClickOnLinks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void getTableInfoFromWeb() throws Exception {
        Document doc = Jsoup.connect(urlLinkTournamentSite).get();
        Element table = doc.select("table").first();
        Elements tds = table.getElementsByTag("td");
        String tableName;
        boolean eachTimer = true;
        for (Element td : tds) {
            tableName = td.text();
            if(eachTimer){
                Log.w("getTableInfoFromWeb","name");
                Log.w("getTableInfoFromWeb", tableName);
                if(!tableName.equals("")) {
                    nameArray.add(tableName);
                    eachTimer = false;
                }
            }
            else{
                Log.w("getTableInfoFromWeb","date");
                Log.w("getTableInfoFromWeb", tableName);
                if(!tableName.equals("")) {
                    dateArray.add(tableName);
                    eachTimer = true;
                }
            }
            System.out.println(tableName);
            Log.w("asd", tableName);

        }

    }

    private void getImageNames() throws IOException { //Skippar de 6 första bilderna samt den sista footbilden
        Document doc = Jsoup.connect(urlLinkTournamentSite).get();
        Elements elements = doc.getElementsByTag("IMG");
        int counter = 1;
        boolean eachTimer = true;
        for(int i=0;i<elements.size();i++)
        {
            if(counter>=7){
                if(eachTimer){
                    if(!elements.get(i).absUrl("src").equals("https://hypefinder.com/webroot/img/footer.png"))
                        logoIconArray.add(elements.get(i).absUrl("src"));
                    eachTimer = false;
                }
                else{
                    if(!elements.get(i).absUrl("src").equals("https://hypefinder.com/webroot/img/footer.png"))
                        flagIconArray.add(elements.get(i).absUrl("src"));
                    eachTimer = true;
                }

            }
            counter++;
        }

    }
    private void getClickOnLinks() throws IOException {
        Document doc = Jsoup.connect(urlLinkTournamentSite).get();
        Elements link = doc.select("td.title > a");

        for(Element text:link){
            String urlIdentifier = text.attr("href");
            linksOnClickarray.add(urlIdentifier);
        }

        for(int i = 0;i<linksOnClickarray.size();i++){          //Ta bort bara loop för test
            Log.d("Watch this", linksOnClickarray.get(i));
        }
    }}


