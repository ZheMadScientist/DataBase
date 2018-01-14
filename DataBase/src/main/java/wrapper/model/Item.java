package wrapper.model;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;

    public  Item(String s){
        name = s;
        try{
            id = Integer.parseInt(s);
        }
        catch (Exception e){}
    }

}
