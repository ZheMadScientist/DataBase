package model;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
