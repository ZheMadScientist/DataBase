package wrapper.model.storage;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( indexes = { @Index ( name = "material_index",  columnList="name", unique = true ) } )
public class Material extends wrapper.model.Entity {

    public String name;

    @Basic
    public String description;

    @ManyToOne//fetch
    public Content content;

    public Material(){}

    public Material(String name, String description, String content){
        this.name = name;
        this.description = description;
        this.content = new Content(content);
    }

}
