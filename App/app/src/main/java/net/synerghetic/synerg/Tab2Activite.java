package net.synerghetic.synerg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by aude on 31/05/2017.
 */

public class Tab2Activite extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2activite, container, false);


        return rootView;
    }


    /**
     * Récupère une liste des urls du feed instagram.
     * @return ArrayList
     */
    public ArrayList getMedias() {

        ArrayList medias = new ArrayList();

        try {
            String myurl= "https://www.instagram.com/synerghetic/media/";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            String result = InputStreamOperations.InputStreamToString(inputStream);

            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);
            // On récupère le tableau d'objets qui nous concernent
            JSONArray array = new JSONArray(jsonObject.getString("items"));
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));
                // On fait le lien Personne - Objet JSON
                //Medias media = new Medias();
                //media.setURL(obj.getString("images.url"));
                // On ajoute la personne à la liste
                //medias.add(media);
                medias.add(obj.getString("images.url"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des personnes
        //Log.i("Tab2Activity", medias);
        for (int i = 0; i < medias.size(); i++) {
            System.out.print(medias.get(i));
        }
        return medias;
    }

}
