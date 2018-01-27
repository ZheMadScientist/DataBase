package wrapper.model.storage;

import lombok.Data;
import wrapper.model.enums.EntityType;
import wrapper.model.enums.MaterialType;
import wrapper.model.storage.content.Content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Material extends wrapper.model.Entity{
    public final MaterialType materialType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String description;

    public String name;

    public Content content;

    public Material(MaterialType materialType, String name, String description, Content content) {
        super(EntityType.Material);
        this.materialType = materialType;
        this.name = name;
        this.description = description;
        this.content = content;
    }

}
