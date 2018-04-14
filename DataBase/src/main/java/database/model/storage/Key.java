package database.model.storage;

import lombok.Data;
import database.model.Entity;

import javax.persistence.OneToOne;

@Data
@javax.persistence.Entity
public class Key extends Entity {

    @OneToOne
    public Task task;

    public String key;
}
