package database.model.storage;

import database.model.Entity;
import lombok.Data;

import javax.persistence.OneToOne;

/**
 * Класс, описывающий ключ к заданию
 */
@Data
@javax.persistence.Entity
public class Key extends Entity {

    /**
     * Задание
     */
    @OneToOne
    public Task task;

    /**
     * Ключ
     */
    public String key;
}
