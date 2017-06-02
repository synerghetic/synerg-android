package net.synerghetic.synerg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aude on 02/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {

    private StandardResolution standard_resolution;

    public Images() {
    }

    public StandardResolution getStandard_resolution() {
        return standard_resolution;
    }

    public void setStandard_resolution(StandardResolution standard_resolution) {
        this.standard_resolution = standard_resolution;
    }
}
