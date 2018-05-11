package database.model;

import database.utils.GuidGenerator;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Entity extends Version {

    @Id
    public long GUID;

    public Entity(){
        GUID = new GuidGenerator().issueNewGUID();
    }

    public Entity(String version, String versionDescription){
        super(version, versionDescription);
        GUID = new GuidGenerator().issueNewGUID();
    }
}
