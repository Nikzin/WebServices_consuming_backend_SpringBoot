package nz.mashupapp.Consumed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Relations {
    public Relations() {}
    private  String type;
    private RelationsURL url;

    public String getType() {
        return type;
    }
    public RelationsURL getUrl() {
        return url;
    }






}
