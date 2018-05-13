package database.utils;

import database.model.storage.AIDS.GuidStorage;

import java.time.LocalDate;
import java.util.Random;

/**
 * Класс, предоставляющий инструменты для генерации глобальных идентификаторов
 */
public class GuidGenerator {

    /**
     * @see GuidStorage
     */
    GuidStorage storage;

    /**
     * Дата создания глобального идентификатора
     */
    LocalDate date;

    public GuidGenerator(){
        storage = GuidStorage.getInstance();
    }

    /**
     * Метод, генерирующий новый глобальный идентификатор с проверкой на уникальность
     * @return
     */
    public long issueNewGUID(){
        date = LocalDate.now();

        long res = 0;

        boolean isUnique = false;

        while (!isUnique){
            res = generateNext();
            isUnique = storage.addGUID(res);
        }

        return generateNext();
    }

    private long generateNext(){
        Random r = new Random();
        return Long.parseLong("" + r.nextInt() + date.getDayOfMonth() + date.getMonthValue() + date.getYear());
    }
}
