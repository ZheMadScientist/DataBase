package database.model.storage.AIDS;

import database.constants.DBConstants;
import database.utils.DBProvider;

import java.util.Set;


public class GuidStorage {

    static GuidStorage instance;

    Set<Long> guids;


    GuidStorage(){
        guids = new DBProvider(DBConstants.PORT).getAllId();
    }

    public static GuidStorage getInstance() {
        if(instance == null)
            instance = new GuidStorage();

        return instance;
    }

    public boolean addGUID(long guid){
        return guids.add(guid);
    }

}
