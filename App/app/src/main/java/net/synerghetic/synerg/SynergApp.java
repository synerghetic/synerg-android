package net.synerghetic.synerg;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by aude on 02/06/2017.
 */

public class SynergApp extends Application{

    private RequestQueue requestQueue;
    private static SynergApp sharedInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        // On assigne notre singleton au démarrage
        SynergApp.sharedInstance = this;

        // 1 queue par application (pour l'exemple ici)
        // mais possibilité d'en avoir plusieurs
        requestQueue = Volley.newRequestQueue(this);

    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static SynergApp getSharedInstance() {
        return sharedInstance;
    }
}
