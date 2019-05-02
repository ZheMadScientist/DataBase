package database.model.storage;

import database.model.tagging.Tags;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

    @OneToOne
    public Tags tags;

    public Material(){}

    public Material(Material another){
        super(another.version, another.versionDescription);
        this.name = another.name;
        this.description = another.description;
        this.content = new Content(another.content);
        this.tags = another.tags;
    }

}
