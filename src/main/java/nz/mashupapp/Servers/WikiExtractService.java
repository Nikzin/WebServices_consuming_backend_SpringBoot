package nz.mashupapp.Servers;

import nz.mashupapp.Consumed.Page;
import nz.mashupapp.Consumed.WikiQuery;
import nz.mashupapp.Consumed.WikiRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
public class WikiExtractService {
    private WikiEntryService wikiEntryService;

WikiExtractService(WikiEntryService wikiEntryService) {
    this.wikiEntryService=wikiEntryService;}


    public String getwikiExtract(String mbid) {
        RestTemplate restTemplate = new RestTemplate();
        String wikiExtract = "not found";
        //get Artist's url's part related to wikipedia API
        String wikiEntry=wikiEntryService.getEntry(mbid);

        if (!wikiEntry.equals("not found")) {
            try {
                String wikiRequerstUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&redirects=true&titles=" + wikiEntry;
                WikiRequest wikiRequest = restTemplate.getForObject(
                        wikiRequerstUrl, WikiRequest.class);

                WikiQuery wikiQuery = wikiRequest.getQuery();
                Map<String, Page> pages = wikiQuery.getPages();
                wikiExtract = "";

                for (Map.Entry<String, Page> entry : pages.entrySet()) {
                    String key = entry.getKey();
                    Page value = entry.getValue();
                    if (wikiExtract.length() == 0) {
                        wikiExtract = value.getExtract();
                    } else {
                        wikiExtract += "<br></br>" + value.getExtract();
                    }//Previously I took the single one and only extract. Now I add them together
                }

            } catch (Exception e) {
                wikiExtract = "not found";
                System.out.println("something wrong with fetching description from wikipedia's api");
            }
        }
return  wikiExtract;
    }
}
