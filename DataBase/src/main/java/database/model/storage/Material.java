package database.model.storage;

import database.model.RequestInfo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Класс, описывающий материал
 */
@Data
@Entity
public class Material extends database.model.Entity {

    public String name;

    public String description;

    /**
     * Контент, который предоставляет материал
     */
    @ManyToOne
    public Content content;

    public RequestInfo requestInfo;

    public Material(){}

    public Material(Material another){
        super(another.version, another.versionDescription);
        this.name = another.name;
        this.description = another.description;
        this.content = new Content(another.content);
        this.requestInfo = another.requestInfo;
    }

}
