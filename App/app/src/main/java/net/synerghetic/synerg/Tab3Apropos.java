package net.synerghetic.synerg;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aude on 31/05/2017.
 */

public class Tab3Apropos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3apropos, container, false);


        String[] history = new String[]{
                "2005, Création de Synerg'hetic", "2006, Label Meilleur Espoir",
                "2010, Entrée dans la liste des 30 meilleures J.E.", "2012, Label Communication",
                "2015, Challenge Junior Partenaires", "2016, Label entrepreneurs",
                "2017, Prix de la meilleur stratégie de communication",
                "2017, Parmi les 4 meilleures J.E. de France"};


        ListView lv = (ListView) rootView.findViewById(R.id.tab3_list);

        ArrayAdapter<String> lva = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, history);
        lv.setAdapter(lva);






        //final List<String[]> history = new LinkedList<String[]>();
        //history.add(new String[] {"2005", "Création de Synerg'hetic"});
        //history.add(new String[] {"2006", "Label Meilleur Espoir"});

        //ArrayAdapter<String[]> adapter = new ArrayAdapter<String[]>(getActivity(), android.R.layout.simple_list_item_2, android.R.id.list, history){

        //    @Override
        //    public View getView(int position, View convertView, ViewGroup parent){
        //        View view = super.getView(position, convertView, parent);

        //        String[] entry = history.get(position);
        //        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
        // TextView text2 = (TextView) view.findViewById(android.R.id.text2);
        //        text1.setText(entry[0]);
        //        text2.setText(entry[1]);

        //        return view;
        //    }
        //};

        //view.setAdapter(adapter);





        return rootView;
    }

}
