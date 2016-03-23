package com.example.henrik.facebook_test_rightversion;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Minkan on 2016-03-23.
 */
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

        list.add(new TutorialObject("LUYG", "LUYG", "https://www.youtube.com/user/LevelUpYourGame", R.drawable.uploader_luyg));
        list.add(new TutorialObject("LUYG", "LUYG", "https://www.youtube.com/user/LevelUpYourGame", R.drawable.uploader_luyg));
        list.add(new TutorialObject("LUYG", "LUYG", "https://www.youtube.com/user/LevelUpYourGame", R.drawable.uploader_luyg));
        list.add(new TutorialObject("JDCR", "JDCR", "https://www.youtube.com/channel/UCPlV0OpQMImKviSTWHJEDiQ", R.drawable.uploader_jdcr));
        list.add(new TutorialObject("JDCR", "JDCR", "https://www.youtube.com/channel/UCPlV0OpQMImKviSTWHJEDiQ", R.drawable.uploader_jdcr));
        list.add(new TutorialObject("JDCR", "JDCR", "https://www.youtube.com/channel/UCPlV0OpQMImKviSTWHJEDiQ", R.drawable.uploader_jdcr));
        list.add(new TutorialObject("ATP", "ATP", "https://www.youtube.com/user/AvoidingthePuddle", R.drawable.uploader_atp));
        list.add(new TutorialObject("ATP", "ATP", "https://www.youtube.com/user/AvoidingthePuddle", R.drawable.uploader_atp));
        list.add(new TutorialObject("ATP", "ATP", "https://www.youtube.com/user/AvoidingthePuddle", R.drawable.uploader_atp));
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
