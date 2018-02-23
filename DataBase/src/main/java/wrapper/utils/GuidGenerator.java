package wrapper.utils;

import wrapper.model.Entity;
import wrapper.model.storage.AIDS.GuidStorage;

import java.time.LocalDate;
import java.util.Random;

public class GuidGenerator {
    GuidStorage storage;
    Entity entity;
    LocalDate date;

    public GuidGenerator(){
        storage = new GuidStorage();
        date = LocalDate.now();
    }

    public GuidGenerator(Entity entity){
        storage = new GuidStorage();
        this.entity = entity;
        date = LocalDate.now();
    }

    public long issueNewGUID(){
        long res = 0;

        boolean isUnique = false;

        while (!isUnique){
            res = generateNext();
            isUnique = storage.guids.add(res);
        }

        return res;
    }

    long generateNext(){
        Random r = new Random();
        if(entity != null) {
            return Long.parseLong("" + r.nextInt() + date.getDayOfMonth() + date.getMonth() + date.getYear());
        }
        return r.nextLong();
    }
}
