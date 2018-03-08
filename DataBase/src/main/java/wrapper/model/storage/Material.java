package wrapper.model.storage;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Material extends wrapper.model.Entity{

    @Basic
    String description;

    @Basic
    String name;

    @ManyToOne//fetch
    Content content;

}
