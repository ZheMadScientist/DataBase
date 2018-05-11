package database.model.storage;

import database.model.Entity;
import lombok.Data;

import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@javax.persistence.Entity
@Table( indexes = { @Index( name = "task_index",  columnList="name,description", unique = false ) } )
public class Task extends Entity {

    public String name;

    public String description;

    @ManyToOne
    public Material material;

    public Task () {}

    public Task (Task old) {
        super(old.version, old.versionDescription.description);
        this.name = old.name;
        this.description = old.description;
        this.material = old.material;
    }
}
