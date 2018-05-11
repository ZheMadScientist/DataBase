package database.model.storage;

import database.model.Entity;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
@javax.persistence.Entity
public class Key extends Entity {

    @OneToOne
    public Task task;

    public String key;
}
