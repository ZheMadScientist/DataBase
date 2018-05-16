package database.model.storage;

import database.model.Entity;
import database.model.RequestInfo;
import lombok.Data;

import javax.persistence.ManyToOne;

/**
 * Класс, описывающий "задание"
 */
@Data
@javax.persistence.Entity
public class Task extends Entity {

    public String name;

    public String description;

    /**
     * Вложенный материал
     */
    @ManyToOne
    public Material material;

    public RequestInfo requestInfo;

    public Task () {}

    public Task (Task old) {
        super(old.version, old.versionDescription);
        this.name = old.name;
        this.description = old.description;
        this.material = old.material;
        this.requestInfo = old.requestInfo;
    }
}
