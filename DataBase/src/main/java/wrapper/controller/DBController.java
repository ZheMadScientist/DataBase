package wrapper.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wrapper.model.Item;

@RestController
public class DBController {


    @RequestMapping("/item")
    public Item item(@RequestParam(value="id", required = false, defaultValue = "1") String id) {
        System.out.println("--------------------GetItem------------------");
        return new Item(id);
    }

    @CrossOrigin
    @RequestMapping("/item-assessconfig")
    public Item itemWithAllowedOrigin(@RequestParam(value="id", required = false, defaultValue = "1") String id) {
        System.out.println("==== in alternate GET ====");
        return new Item(id);
    }
}
