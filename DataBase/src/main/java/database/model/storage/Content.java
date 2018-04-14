package database.model.storage;

import lombok.Data;
import database.model.Entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;

@Data
@javax.persistence.Entity
@Access(AccessType.FIELD)
public class Content extends Entity {

    @Column(columnDefinition = "text")
    public String content;

    public Content(){}

    public Content(String content){
        this.content = content;
    }

    public Content(Content another){
        this.content = another.content;
    }
}
