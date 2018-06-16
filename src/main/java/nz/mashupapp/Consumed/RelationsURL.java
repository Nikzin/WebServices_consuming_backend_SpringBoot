package nz.mashupapp.Consumed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelationsURL {


    private String resource;
    private String id;

    public RelationsURL() {
    }
    public String getResource() {
        return resource;
    }

    public String getId() {
        return id;
    }
}
