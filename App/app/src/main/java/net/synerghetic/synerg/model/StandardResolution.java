package net.synerghetic.synerg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aude on 02/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandardResolution {

    private String url;

    public StandardResolution() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
