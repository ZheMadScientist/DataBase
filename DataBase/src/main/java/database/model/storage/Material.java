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

    @ManyToOne//fetch
    public Content content;

    public Material(){}

    public Material(String name, String description, String content){
        this.name = name;
        this.description = description;
        this.content = new Content(content);
    }

    public Material(Material another){
        this.name = another.name;
        this.description = another.description;
        this.content = new Content(another.content);
    }

}
