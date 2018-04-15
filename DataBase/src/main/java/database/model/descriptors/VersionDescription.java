package database.model.descriptors;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class VersionDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long version_description_id;

    @Column(columnDefinition = "text")
    public String description;

    public VersionDescription(){}

    public VersionDescription(String description){
        if(description != null)
            this.description = description;
        else description = "";
    }

}
