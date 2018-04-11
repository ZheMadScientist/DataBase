package wrapper.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Entity extends Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long GUID;

}
