package wrapper.model.stat.log;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserLog extends wrapper.model.Entity{

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long uLogID;

    @Basic
    public String data;

}
