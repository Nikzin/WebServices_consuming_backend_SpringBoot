package nz.mashupapp.Consumed;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {
    public Artist(){};

    private ArrayList<Relations> relations=new ArrayList<>();

    public ArrayList<Relations> getRelations() {
        return relations;
    }


}
