package nz.mashupapp.Servers;

import nz.mashupapp.Consumed.Artist;
import nz.mashupapp.Consumed.Relations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class WikiEntryService {
    public String getEntry(String mbid) {
        RestTemplate restTemplate = new RestTemplate();
        String wikiEntry = "not found";
        String artistURL = "http://musicbrainz.org/ws/2/artist/" + mbid + "?&fmt=json&inc=url-rels";
        try {
            Artist artist = restTemplate.getForObject(
                    artistURL, Artist.class);
            ArrayList<Relations> relations = artist.getRelations();
            for (Relations rr : relations) {
                String rType = rr.getType();
                if (rType.equals("wikipedia")) {
                    String urlWiki = rr.getUrl().getResource();
                    String[] result = urlWiki.split("\\/");
                    wikiEntry = result[result.length - 1];
                }
            }
        } catch (Exception e) {
            wikiEntry = "not found";
            System.out.println("something wrong with fetching wikipedia's url from mbid api relations");
        }
        return wikiEntry;
    }

}
