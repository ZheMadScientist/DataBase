package wrapper.api;

import org.springframework.web.client.RestTemplate;
import wrapper.model.Item;

public class DBProvider {
    RestTemplate restTemplate;
    String URI;

    public  DBProvider(String uri){
        restTemplate = new RestTemplate();
        URI = uri;
    }

    public Item getItem(){
        return restTemplate.getForObject(URI, Item.class);
    }
    
}
