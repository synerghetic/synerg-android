package net.synerghetic.synerg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aude on 07/06/2017.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class FeaturedImage {

    private String guid;

    public FeaturedImage() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
