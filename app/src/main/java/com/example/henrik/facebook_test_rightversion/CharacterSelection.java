package com.example.henrik.facebook_test_rightversion;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterSelection extends Fragment {
    private int[] characterPortraits = new int[]{R.drawable.character_akuma, R.drawable.character_alisa,R.drawable.character_asuka,R.drawable.character_bryan,R.drawable.character_claudio,R.drawable.character_deviljin,R.drawable.character_dragunov,R.drawable.character_feng,R.drawable.character_gigas,R.drawable.character_heihachi,R.drawable.character_hwoarang,R.drawable.character_jack7,R.drawable.character_jin,R.drawable.character_josie,R.drawable.character_katarina,R.drawable.character_kazumi,R.drawable.character_kazuya,R.drawable.character_king,R.drawable.character_lars,R.drawable.character_law,R.drawable.character_leo,R.drawable.character_lili,R.drawable.character_luckychloe,R.drawable.character_nina,R.drawable.character_paul,R.drawable.character_shaheen,R.drawable.character_steve,R.drawable.character_xiaoyu,R.drawable.character_yoshimitsu};
    private String[] characterNames = {"akuma", "alisa", "asuka", "bryan","claudio","deviljin","dragunov","feng","gigas","heihachi","hwoarang","jack7","jin","josie","katarina","kazumi","kazuya","king","lars","law","leo","lili","luckychloe","nina","paul","shaheen","steve","xiaoyu","yoshimitsu"};
    private String imagePressed = "";
    private TextView infoText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_character_selection, container, false);

        imagePressed = this.getArguments().getString("imagePressed");

        infoText = (TextView) view.findViewById(R.id.infoText);
        if(imagePressed.equals("player") || imagePressed.equals("movelist")){
            infoText.setText("Select your character:");
        }
        else if(imagePressed.equals("opponent")){
            infoText.setText("Select your opponent:");
        }

        GridView characterSelector = (GridView) view.findViewById(R.id.characterSelector);
        characterSelector.setAdapter(new ImageAdapter(view.getContext()));                          // uses the view to get the context instead of getActivity().

        characterSelector.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                setCharacterPortrait(position);
                getActivity().getFragmentManager().popBackStack();
            }
        });

        return view;
    }

    private void setCharacterPortrait(int id){
        ImageView newCharacter = null;

        switch(imagePressed){
            case "player":
                newCharacter = (ImageView)getActivity().findViewById(R.id.playerPortrait);
                ((PunishmentViewer)getActivity()).setPlayerCharacter(characterNames[id]);
                break;
            case "opponent":
                newCharacter = (ImageView)getActivity().findViewById(R.id.opponentPortrait);
                ((PunishmentViewer)getActivity()).setOpponentCharacter(characterNames[id]);
                break;
            case "movelist":
                newCharacter = (ImageView)getActivity().findViewById(R.id.playerPortrait);
                ((MovelistViewer)getActivity()).setPlayerCharacter(characterNames[id]);
                break;
        }

        newCharacter.setImageResource(characterPortraits[id]);
    }
}
