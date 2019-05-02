package database.model.storage;

import database.model.Entity;
import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;

/**
 * Класс, описывающий контент
 */
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
