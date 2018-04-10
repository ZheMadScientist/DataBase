package wrapper.model.storage;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Material extends wrapper.model.Entity implements Serializable{

    @Basic
    String description;

    @Basic
    String name;

    @ManyToOne//fetch
    Content content;

}
