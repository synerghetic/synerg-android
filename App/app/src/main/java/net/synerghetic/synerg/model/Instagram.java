package net.synerghetic.synerg.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aude on 02/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Instagram implements Parcelable {

    private Images images;

    public Instagram() {
    }

    public Instagram(Images images) {
        this.images = images;
    }


    public Instagram(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Instagram> CREATOR = new Creator<Instagram>() {
        @Override
        public Instagram createFromParcel(Parcel in) {
            return new Instagram(in);
        }

        @Override
        public Instagram[] newArray(int size) {
            return new Instagram[size];
        }
    };

    /* Getters and setters*/

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
