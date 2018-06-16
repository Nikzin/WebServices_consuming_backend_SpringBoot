package nz.mashupapp.Consumed;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiQuery {

    public WikiQuery() {
    }

    private Map<String, Page> pages= new HashMap<String, Page>();

    public Map<String, Page> getPages() {
        return pages;
    }

    public void setPages(Map<String, Page> pages) {
        this.pages = pages;
    }



}
