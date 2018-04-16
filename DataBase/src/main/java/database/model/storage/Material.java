package database.model.storage;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( indexes = { @Index ( name = "material_index",  columnList="name,description", unique = true ) } )
public class Material extends database.model.Entity {

    @Column(columnDefinition = "text")
    public String name;

    @Column(columnDefinition = "text")
    public String description;

    @ManyToOne
    public Content content;

    public Material(){}

    public Material(Material another){
        super(another.version, another.versionDescription.description);
        this.name = another.name;
        this.description = another.description;
        this.content = new Content(another.content);
    }

}
