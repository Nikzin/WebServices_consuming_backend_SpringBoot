package nz.mashupapp.Servers;

import nz.mashupapp.Consumed.Album;
import nz.mashupapp.Consumed.AlbumAndImage;
import nz.mashupapp.Consumed.Albums;
import nz.mashupapp.Consumed.Images;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class AlbumAndImageList {



    public ArrayList<AlbumAndImage> getList(String mbid){
        String albumsUrl = "http://musicbrainz.org/ws/2/artist/" + mbid + "?&fmt=json&inc=release-groups";
        ArrayList<AlbumAndImage> albumAndImageArrayList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        Albums albums = restTemplate.getForObject(
                albumsUrl, Albums.class);

        //this will be the list of albums PLUS images's urls and this part takes a lion part of web fetching time for each image url
        //fetch image's URLs for each album and making new albumList with images included
        //filter away: add only those elements which are type of "Album"
        for (Album aa : albums.getRelease_groups()) {
            String albumUrl = "http://coverartarchive.org/release-group/" + aa.getId();
            String imageUrl;
            try {
                Images images = restTemplate.getForObject(
                        albumUrl, Images.class);
                imageUrl = (images.getImages()).get(0).getImage();
            } catch (Exception e) {
                imageUrl = "not found";
            }

            if (aa.getPrimaryType().equals("Album")) {
                albumAndImageArrayList.add(new AlbumAndImage(aa.getTitle(), aa.getId(), imageUrl));
            }
        }
        return albumAndImageArrayList;
    }
}
