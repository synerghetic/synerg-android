package net.synerghetic.synerg.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import net.synerghetic.synerg.SynergApp;
import net.synerghetic.synerg.model.Blog;
import net.synerghetic.synerg.model.BlogResult;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aude on 07/06/2017.
 */

public class BlogService {

    public interface BlogListener {
        void onBlogReceived(List<Blog> blog);
        void onFailed();
    }

    public static void getBlog(final BlogService.BlogListener blogListener) {

        JacksonRequest<BlogResult> request;

        request = new JacksonRequest<BlogResult>(Request.Method.GET, "http://www.audeficheux.com/blogposts.json", new JacksonRequestListener<BlogResult>() {
            @Override
            public void onResponse(BlogResult response, int statusCode, VolleyError error) {
                if (blogListener == null) {
                    return;
                }

                if (response != null) {
                    blogListener.onBlogReceived(Arrays.asList(response.getItems()));
                }

                if (error != null) {
                    blogListener.onFailed();
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(BlogResult.class);
            }
        });
        SynergApp
                .getSharedInstance()
                .getRequestQueue()
                .add(request);
    }
}
