package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class Task extends Entity {

    String name;

    String description;

    @ManyToOne
    Material material;
}
