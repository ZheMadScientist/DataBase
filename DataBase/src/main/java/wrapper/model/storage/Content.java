package wrapper.model.storage;

import lombok.Data;
import wrapper.model.Entity;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.html.HTMLDocument;

@Data
public class Content extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    public HTMLDocument content;
}
