package wrapper.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wrapper.model.storage.Material;

@RestController
public class DBRestController {

    @CrossOrigin
    @RequestMapping("/material")
    public Material itemWithAllowedOrigin(@RequestParam(value="name", required = false, defaultValue = "1") String name) {
        //return new Material(MaterialType.URL, name, "", new Content(ContentType.URL));
        return null;
    }
}
