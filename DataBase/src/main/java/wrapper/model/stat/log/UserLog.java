package wrapper.model.stat.log;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@Entity
public class UserLog extends wrapper.model.Entity{

    @Basic
    public String data;

}
