package database.utils;

import database.model.storage.AIDS.GuidStorage;

import java.time.LocalDate;
import java.util.Random;

public class GuidGenerator {
    GuidStorage storage;
    LocalDate date;

    public GuidGenerator(){
        storage = GuidStorage.getInstance();
        date = LocalDate.now();
    }

    public long issueNewGUID(){
        long res = 0;

        boolean isUnique = false;

        while (!isUnique){
            res = generateNext();
            isUnique = storage.addGUID(res);
        }

        return generateNext();
    }

    long generateNext(){
        Random r = new Random();
        return Long.parseLong("" + r.nextInt() + date.getDayOfMonth() + date.getMonthValue() + date.getYear());
    }
}
