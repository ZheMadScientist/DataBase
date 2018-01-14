package wrapper.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wrapper.model.Item;

@RestController
public class DBController {

    @RequestMapping("/item")
    public Item item(@RequestParam(value="id", required = false, defaultValue = "1") String id) {
        return new Item(id);
    }
}
