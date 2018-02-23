package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.*;
import javax.swing.text.html.HTMLDocument;

@Data
@javax.persistence.Entity
@Access(AccessType.FIELD)
public class Content extends Entity {

    @Basic
    public String content;
}
