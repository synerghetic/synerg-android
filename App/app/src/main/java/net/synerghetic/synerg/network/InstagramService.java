package net.synerghetic.synerg.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import net.synerghetic.synerg.SynergApp;
import net.synerghetic.synerg.model.Instagram;
import net.synerghetic.synerg.model.InstagramResult;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aude on 02/06/2017.
 */

public class InstagramService {

    public interface InstagramListener {
        void onInstagramReceived(List<Instagram> instagram);
        void onFailed();
    }

    public static void getInstagram(final InstagramListener instagramListener) {

        JacksonRequest<InstagramResult> request;

        request = new JacksonRequest<InstagramResult>(Request.Method.GET, "https://www.instagram.com/synerghetic/media/", new JacksonRequestListener<InstagramResult>() {
            @Override
            public void onResponse(InstagramResult response, int statusCode, VolleyError error) {
                if (instagramListener == null) {
                    return;
                }

                if (response != null) {
                    instagramListener.onInstagramReceived(Arrays.asList(response.getItems()));
                }

                if (error != null) {
                    instagramListener.onFailed();
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(InstagramResult.class);
            }
        });
        SynergApp
                .getSharedInstance()
                .getRequestQueue()
                .add(request);
    }
}
