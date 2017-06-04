package net.synerghetic.synerg.fragments;

/**
 * Created by aude on 31/05/2017.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.synerghetic.synerg.R;

import java.util.ArrayList;

public class Tab1Bureau extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1bureau, container, false);

        String[] members = new String[]{
                "Juliette, Présidente", "Aude, Secrétaire Générale",
                "Vanessa, Trésorière", "Sébastien, Vice-Trésorier",
                "Pierre, Résponsable Relations Publiques", "Yann-Edern, Responsable Projets",
                "Constance, Responsable Projets", "Aymeric, Responsable Qualité",
                "Anthelme, Responsable Commercial", "Antoine, Responsable Commercial", "Jules, Responsable Prospection"};



        for (String members : members) {
            mWeatherTextView.append(members + "next");
        }
        //ArrayList<String> medias = Medias.getMedias();

        //String[] mediaString = new String[medias.size()];
        //mediaString = medias.toArray(mediaString);


        ListView lv = (ListView) rootView.findViewById(R.id.tab1_list);

        ArrayAdapter<String> lva = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, members);
        lv.setAdapter(lva);

        return rootView;
    }

}
