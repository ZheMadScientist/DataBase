package database.model.storage.AIDS;

import database.constants.DBConstants;
import database.utils.DBProvider;

import java.util.Set;

/**
 * Синглтон, предоставляющий доступ ко всем существующим глобальным идентификаторам
 */
public class GuidStorage {

    /**
     * Текущий инстанс класса
     */
    private static GuidStorage instance;

    /**
     * Сет всех существующих глобальных идентификаторов
     */
    private Set<Long> guids;


    GuidStorage(){
        guids = new DBProvider(DBConstants.PORT).getAllId();
    }

    /**
     * @return {@linkplain GuidStorage} истанс
     */
    public static GuidStorage getInstance() {
        if(instance == null)
            instance = new GuidStorage();

        return instance;
    }

    /**
     * Метод добавления нового GUID
     * @param guid новый глобальный идентификатор
     * @return {@code true} если такого GUID еще нет, иначе {@code false}
     */
    public boolean addGUID(long guid){
        return guids.add(guid);
    }

    /**
     * Метод, проверяющий существует ли уже определенный GUID
     * @param guid глобальный идентификатор
     * @return {@code true} если существует, иначе {@code false}
     */
    public boolean contains(long guid){
        return guids.contains(guid);
    }

}
