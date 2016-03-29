package com.example.henrik.facebook_test_rightversion;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpecificsFragment extends Fragment {

    private ArrayList<TutorialObject> list = new ArrayList();
    private ArrayList<TutorialObject> sortedList = new ArrayList();
    private Spinner spinner;

    private ListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.specifics, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list.add(new TutorialObject("Morning Bread & Butter - Ep1 - Jinpachi Mishima", "LUYG", "https://www.youtube.com/watch?v=S2jibLH9-k4&index=1", R.drawable.uploader_luyg));
        list.add(new TutorialObject("Morning Bread & Butter - Ep 2 - True Ogre", "LUYG", "https://www.youtube.com/watch?v=Bp3RAFmzZb0&index=2", R.drawable.uploader_luyg));
        list.add(new TutorialObject("Morning Bread & Butter - Ep 3 - Forest Law", "LUYG", "https://www.youtube.com/watch?v=qTCvQUUMgbs", R.drawable.uploader_luyg));
        list.add(new TutorialObject("Morning Bread & Butter - Ep 4 - Jun Kazama", "LUYG", "https://www.youtube.com/watch?v=FGeFi20yy8U", R.drawable.uploader_luyg));
        list.add(new TutorialObject("Morning Bread & Butter - Ep 5 - Paul Phoenix", "LUYG", "https://www.youtube.com/watch?v=IcMHgoEl_2E", R.drawable.uploader_luyg));


        list.add(new TutorialObject("JDCR's tekken lesson #1 Let it go", "JDCR", "https://www.youtube.com/watch?v=7ylizAss-4k", R.drawable.uploader_jdcr));
        list.add(new TutorialObject("JDCR's tekken lesson #2 when not to move", "JDCR", "https://www.youtube.com/watch?v=BCNRDnNNF0A", R.drawable.uploader_jdcr));
        list.add(new TutorialObject("JDCR's tekken lesson #3 When to do Backdash (Law)", "JDCR", "https://www.youtube.com/watch?v=nUihs9P1N24", R.drawable.uploader_jdcr));
        list.add(new TutorialObject("JDCR's tekken lesson #4 Side step and Duck (Steve)", "JDCR", "https://www.youtube.com/watch?v=BhZWtd-6aYM", R.drawable.uploader_jdcr));
        list.add(new TutorialObject("JDCR tekken TIp #7 Basic Oki", "JDCR", "https://www.youtube.com/watch?v=182CR-JWwZA", R.drawable.uploader_jdcr));

        list.add(new TutorialObject("TTT2 - Armor King tutorial part 1 of 5 - Intro, Punishers, Throws", "ATP", "https://www.youtube.com/watch?v=g9-qo4Lcdok&index=1", R.drawable.uploader_atp));
        list.add(new TutorialObject("TTT2 - Armor King tutorial part 2 of 5 - Pokes, and Move Breakdown", "ATP", "https://www.youtube.com/watch?v=DWB5yg-0Dko&index=2", R.drawable.uploader_atp));
        list.add(new TutorialObject("TTT2 - Armor King tutorial part 3 of 5 - Movelist Breakdown", "ATP", "https://www.youtube.com/watch?v=68OI9u0_OdM&index=3", R.drawable.uploader_atp));
        list.add(new TutorialObject("TTT2 - Armor King tutorial part 4 of 5 - Wall Game", "ATP", "https://www.youtube.com/watch?v=A6gnNK4VPU4", R.drawable.uploader_atp));
        list.add(new TutorialObject("TTT2 - Armor King tutorial part 5 of 5 - More Wall Game, and Wrap up", "ATP", "https://www.youtube.com/watch?v=ZaJVCTwJBIM", R.drawable.uploader_atp));

        list.add(new TutorialObject("Devil Jin Guide", "TMM", "https://www.youtube.com/watch?v=ZZ29NSb1r6s&index=1", R.drawable.uploader_tmm));
        list.add(new TutorialObject("Heihachi Mishima Guide", "TMM", "https://www.youtube.com/watch?v=15ywUJzskuU&index=3", R.drawable.uploader_tmm));
        list.add(new TutorialObject("Kazuya Mishima Guide", "TMM", "https://www.youtube.com/watch?v=ZSTEXcJqxGM&index=4", R.drawable.uploader_tmm));

        spinner = (Spinner) getView().findViewById(R.id.upploaderChoice);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                fillList();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> listAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.uploaders_array, R.layout.custom_spinner);
        spinner.setAdapter(listAdapter);

    }

    public void fillList(){

        final ListView specTut = (ListView) getView().findViewById(R.id.specificsList);
        listChoice();
        specTut.setAdapter(adapter);
        specTut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(list.get(position).getUrl()));

                startActivity(i);
            }
        });
    }

    public void listChoice(){


        String choice = spinner.getSelectedItem().toString();

        if(choice.equals("All")){
            adapter = new TutorialAdapter(getActivity(), list);
        }else {
            sortedList.clear();
            for(int i =0; i < list.size(); i++) {
                if (list.get(i).getUpploader().equals(choice)) {
                    sortedList.add(list.get(i));
                }
            }
            adapter = new TutorialAdapter(getActivity(), sortedList);
        }
    }
}
