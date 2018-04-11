package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@javax.persistence.Entity
@Table( indexes = { @Index( name = "task_index",  columnList="name,description", unique = true ) } )
public class Task extends Entity {

    public String name;

    public String description;

    @ManyToOne
    public Material material;
}
