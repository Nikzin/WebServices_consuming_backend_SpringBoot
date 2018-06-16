package nz.mashupapp.Consumed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Images {
    public Images() {}

    private ArrayList<Image> images;

    public ArrayList<Image> getImages() {
        return images;
    }




}
