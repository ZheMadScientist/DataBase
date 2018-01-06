package model;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
