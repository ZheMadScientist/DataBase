package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@javax.persistence.Entity
public class Task extends Entity implements Serializable{

    public String name;

    public String description;

    @ManyToOne
    public Material material;
}
