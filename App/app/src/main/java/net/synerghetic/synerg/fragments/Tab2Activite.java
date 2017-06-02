package net.synerghetic.synerg.fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.synerghetic.synerg.R;
import net.synerghetic.synerg.model.Instagram;
import net.synerghetic.synerg.model.StandardResolution;
import net.synerghetic.synerg.network.InstagramService;

import java.util.List;

/**
 * Created by aude on 31/05/2017.
 */

public class Tab2Activite extends Fragment {


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2activite, container, false);

        InstagramService.getInstagram(new InstagramService.InstagramListener() {
            @Override
            public void onInstagramReceived(List<Instagram> instagrams) {
                for (Instagram instagram : instagrams){
                    String imageUrl = instagram.getImages().getStandard_resolution().getUrl();
                    System.out.println(imageUrl);
                }
            }

            @Override
            public void onFailed() {

            }
        });


        

        return rootView;
    }



}
