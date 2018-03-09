package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Data
@javax.persistence.Entity
public class Task extends Entity implements Serializable{

    @Id
    @GeneratedValue
    long task_id;


    String name;

    String description;

    @ManyToOne
    Material material;
}
