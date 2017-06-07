package net.synerghetic.synerg.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aude on 07/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Blog implements Parcelable {

    private FeaturedImage featured_image;

    public Blog() {
    }

    public Blog(FeaturedImage featured_image) {
        this.featured_image = featured_image;
    }


    public Blog(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Blog> CREATOR = new Creator<Blog>() {
        @Override
        public Blog createFromParcel(Parcel in) {
            return new Blog(in);
        }

        @Override
        public Blog[] newArray(int size) {
            return new Blog[size];
        }
    };

    /* Getters and setters*/

    public FeaturedImage getFeaturedImage() {
        return featured_image;
    }

    public void setFeaturedImage(FeaturedImage featured_image) {
        this.featured_image = featured_image;
    }

}
