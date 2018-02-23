package wrapper.model.storage;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Material extends wrapper.model.Entity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    public String description;

    @Basic
    public String name;

    @Basic
    public Content content;

}
