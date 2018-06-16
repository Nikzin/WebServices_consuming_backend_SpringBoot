package nz.mashupapp.Consumed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    public Image() {}

    private String image;



    public String getImage() {
        return image;
    }
}
