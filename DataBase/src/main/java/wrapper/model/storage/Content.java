package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;

@Data
@javax.persistence.Entity
@Access(AccessType.FIELD)
public class Content extends Entity {

    @Basic
    public String content;
}
