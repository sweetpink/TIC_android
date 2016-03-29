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


public class BasicsFragment extends Fragment {

    ArrayList<TutorialObject> list = new ArrayList();
    ArrayList<TutorialObject> sortedList = new ArrayList();
    Spinner spinner;

    ListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.basics, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list.add(new TutorialObject("TEKKEN TAG TOURNAMENT 2 - Tutorial Video #1 - The Basics", "LUYG", "https://www.youtube.com/watch?v=OtpT4ejbGwk&index=1&list=PLVYulCamEPqLIJXEn-RZ9oDeKMfPBammY", R.drawable.uploader_luyg));
        list.add(new TutorialObject("TEKKEN TAG TOURNAMENT 2 - Tutorial Video #2 - Intermediate 1 of 2", "LUYG", "https://www.youtube.com/watch?v=icaOdA7HSOU&index=2&list=PLVYulCamEPqLIJXEn-RZ9oDeKMfPBammY", R.drawable.uploader_luyg));
        list.add(new TutorialObject("TEKKEN TAG TOURNAMENT 2 - Tutorial Video #3 - Intermediate 2 of 2", "LUYG", "https://www.youtube.com/watch?v=b23HuTEhTdc&index=3&list=PLVYulCamEPqLIJXEn-RZ9oDeKMfPBammY", R.drawable.uploader_luyg));
        list.add(new TutorialObject("TEKKEN TAG TOURNAMENT 2 - Tutorial Video #4 - Combos", "LUYG", "https://www.youtube.com/watch?v=cVtPed3nBno&index=4&list=PLVYulCamEPqLIJXEn-RZ9oDeKMfPBammY", R.drawable.uploader_luyg));
        list.add(new TutorialObject("TEKKEN TAG TOURNAMENT 2 - Tutorial Video #5 - Advanced 1/2", "LUYG", "https://www.youtube.com/watch?v=mejjnRdG2po&index=5&list=PLVYulCamEPqLIJXEn-RZ9oDeKMfPBammY", R.drawable.uploader_luyg));
        list.add(new TutorialObject("TEKKEN TAG TOURNAMENT 2 - Tutorial Video #6 - Advanced 2/2", "LUYG", "https://www.youtube.com/watch?v=9z8s21qGM2o&index=6&list=PLVYulCamEPqLIJXEn-RZ9oDeKMfPBammY", R.drawable.uploader_luyg));

        list.add(new TutorialObject("TTT2 Korean Back Dash Tutorial Part 1 (1P Side)", "ATP", "https://www.youtube.com/watch?v=gLp3Y0PdV94&list=PLMCyLSAjLlQ2hzsXTwVzKv4HR0ouxJNRm&index=1", R.drawable.uploader_atp));
        list.add(new TutorialObject("TTT2 Korean Back Dash Tutorial Part 2 (2P Side)", "ATP", "https://www.youtube.com/watch?v=gGee7eL9Vrk&list=PLMCyLSAjLlQ2hzsXTwVzKv4HR0ouxJNRm&index=2", R.drawable.uploader_atp));
        list.add(new TutorialObject("Movement Tutorial for Tekken 6 and TTT2 Part 1: The Basics", "ATP", "https://www.youtube.com/watch?v=Z-_trL1pZeo&list=PLMCyLSAjLlQ2hzsXTwVzKv4HR0ouxJNRm&index=3", R.drawable.uploader_atp));
        list.add(new TutorialObject("Movement Tutorial for TTT2 and Tekken 6 Part 2: Advanced", "ATP", "https://www.youtube.com/watch?v=ZmwTz9FOwxQ&list=PLMCyLSAjLlQ2hzsXTwVzKv4HR0ouxJNRm&index=4", R.drawable.uploader_atp));
        list.add(new TutorialObject("TTT2 Rage and Tag Crash Tutorial", "ATP", "https://www.youtube.com/watch?v=3LPu8LkR6aM&list=PLMCyLSAjLlQ2hzsXTwVzKv4HR0ouxJNRm&index=5", R.drawable.uploader_atp));
        list.add(new TutorialObject("TTT2 Raw Tag Safety Tutorial", "ATP", "https://www.youtube.com/watch?v=1_zusa7s7hI&list=PLMCyLSAjLlQ2hzsXTwVzKv4HR0ouxJNRm&index=6", R.drawable.uploader_atp));

        list.add(new TutorialObject("TMM", "TMM", "https://www.youtube.com/user/MitsuGTO885", R.drawable.uploader_tmm));
        list.add(new TutorialObject("TMM", "TMM", "https://www.youtube.com/user/MitsuGTO885", R.drawable.uploader_tmm));
        list.add(new TutorialObject("TMM", "TMM", "https://www.youtube.com/user/MitsuGTO885", R.drawable.uploader_tmm));
        list.add(new TutorialObject("TMM", "TMM", "https://www.youtube.com/user/MitsuGTO885", R.drawable.uploader_tmm));
        list.add(new TutorialObject("TMM", "TMM", "https://www.youtube.com/user/MitsuGTO885", R.drawable.uploader_tmm));
        list.add(new TutorialObject("TMM", "TMM", "https://www.youtube.com/user/MitsuGTO885", R.drawable.uploader_tmm));

        spinner = (Spinner) getView().findViewById(R.id.upploaderChoice2);

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

        final ListView basTut = (ListView) getView().findViewById(R.id.basicsList);
        listChoice();
        basTut.setAdapter(adapter);
        basTut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
