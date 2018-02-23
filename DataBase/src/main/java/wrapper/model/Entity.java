package wrapper.model;

import lombok.Data;
import wrapper.utils.GuidGenerator;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class Entity extends Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long GUID;

}
