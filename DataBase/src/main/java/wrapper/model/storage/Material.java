package wrapper.model.storage;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity
public class Material extends wrapper.model.Entity implements Serializable{

    @Basic
    public String description;

    @Basic
    public String name;

    @ManyToOne//fetch
    public Content content;

}
