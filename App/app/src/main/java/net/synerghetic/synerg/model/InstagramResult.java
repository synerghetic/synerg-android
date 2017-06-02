package net.synerghetic.synerg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.synerghetic.synerg.model.Instagram;

/**
 * Created by aude on 02/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramResult {

    private Instagram[] items;

    public InstagramResult() {
    }

    public Instagram[] getItems() {
        return items;
    }

    public void setItems(Instagram[] items) {
        this.items = items;
    }
}
