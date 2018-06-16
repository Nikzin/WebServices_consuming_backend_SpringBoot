package nz.mashupapp.Consumed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {
    public Album() {}


    private String title;
    private String id;
    @JsonProperty("primary-type")
    private String primaryType;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getPrimaryType() {
        return primaryType;
    }
}
