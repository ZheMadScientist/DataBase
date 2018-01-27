package wrapper.model;

import lombok.Data;
import wrapper.model.enums.EntityType;
import wrapper.utils.GuidGenerator;

import javax.persistence.Id;

@Data
public class Entity extends Version {

    @Id
    public final long GUID;

    public final EntityType entityType;

    public Entity(EntityType entityType) {
        GUID = new GuidGenerator(this).issueNewGUID();
        this.entityType = entityType;
    }
}
