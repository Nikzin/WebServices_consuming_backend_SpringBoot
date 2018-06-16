package nz.mashupapp.Consumed;

import java.util.ArrayList;

public class TheResponse {
    public TheResponse() {
    }



    private String mbid;
    private String description;


   private ArrayList<AlbumAndImage> albums = new ArrayList<>();

    // private ArrayList<Album> albums; //if we want an alternative w/o images urls

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<AlbumAndImage> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<AlbumAndImage> albums) {
        this.albums = albums;
    }


}
