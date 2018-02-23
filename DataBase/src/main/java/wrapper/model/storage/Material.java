package wrapper.model.storage;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Material extends wrapper.model.Entity{

    @Basic
    public String description;

    @Basic
    public String name;

    //@Basic
    //public Content content;

}
