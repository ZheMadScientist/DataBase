package wrapper.model;

import lombok.Data;
import wrapper.utils.GuidGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Entity extends Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long GUID;

}
