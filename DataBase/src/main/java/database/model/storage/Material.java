package database.model.storage;

import lombok.Data;

import javax.persistence.*;

/**
 * Класс, описывающий материал
 */
@Data
@Entity
@Table( indexes = { @Index ( name = "material_index",  columnList="name,description", unique = true ) } )
public class Material extends database.model.Entity {

    public String name;

    public String description;

    /**
     * Контент, который предоставляет материал
     */
    @ManyToOne
    public Content content;

    public Material(){}

    public Material(Material another){
        super(another.version, another.versionDescription);
        this.name = another.name;
        this.description = another.description;
        this.content = new Content(another.content);
    }

}
