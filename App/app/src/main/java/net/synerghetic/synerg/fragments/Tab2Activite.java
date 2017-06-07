package net.synerghetic.synerg.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.synerghetic.synerg.R;
import net.synerghetic.synerg.model.Blog;
import net.synerghetic.synerg.model.Instagram;
import net.synerghetic.synerg.network.ImageLoadTask;
import net.synerghetic.synerg.network.InstagramService;
import net.synerghetic.synerg.network.BlogService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by aude on 31/05/2017.
 */

public class Tab2Activite extends Fragment {


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab2activite, container, false);



        InstagramService.getInstagram(new InstagramService.InstagramListener() {
            @Override
            public void onInstagramReceived(List<Instagram> instagrams) {
                int index = 0;
                for (Instagram instagram : instagrams){
                    index++;
                    String imageUrl = instagram.getImages().getStandard_resolution().getUrl();
                    //System.out.println(imageUrl);

                    String viewID = "instaView" + index;
                    int resID = getResources().getIdentifier(viewID, "id", "net.synerghetic.synerg");

                    //ImageView img = (ImageView) rootView.findViewById(R.id.instaView1);
                    ImageView img = (ImageView) rootView.findViewById(resID);
                    //System.out.println(img);

                    if (img != null) {
                        new ImageLoadTask(imageUrl, img).execute();
                    }
                }
            }

            @Override
            public void onFailed() {

            }
        });


        BlogService.getBlog(new BlogService.BlogListener() {
            @Override
            public void onBlogReceived(List<Blog> blogs) {
                for (Blog blog : blogs){
                    String imgUrl = blog.getFeaturedImage().getGuid();
                    System.out.println(imgUrl);
                }
            }

            @Override
            public void onFailed() {

            }
        });




        return rootView;
    }



}
