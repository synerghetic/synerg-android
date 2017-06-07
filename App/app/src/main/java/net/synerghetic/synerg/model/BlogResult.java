package net.synerghetic.synerg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aude on 07/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogResult {

    private Blog[] items;

    public BlogResult() {
    }

    public Blog[] getItems() {
        return items;
    }

    public void setItems(Blog[] items) {
        this.items = items;
    }
}
