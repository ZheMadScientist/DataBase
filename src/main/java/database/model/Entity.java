package database.model;

import database.utils.GuidGenerator;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Базовый класс для сущностей базы данных
 */
@Data
@MappedSuperclass
public class Entity extends Version {

    /**
     * Глобальный идентификатор
     */
    @Id
    public long GUID;

    public Entity(){
        GUID = new GuidGenerator().issueNewGUID();
    }

    public Entity(String version, String versionDescription){
        super(version, versionDescription);
        GUID = new GuidGenerator().issueNewGUID();
    }
}
