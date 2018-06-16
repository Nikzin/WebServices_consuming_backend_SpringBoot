package nz.mashupapp.Consumed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Albums {
    public Albums() {}
    @JsonProperty("release-groups")
    private ArrayList<Album>  release_groups = new ArrayList<>();

    public ArrayList<Album> getRelease_groups() {
        return release_groups;
    }




}
