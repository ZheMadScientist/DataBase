package database.dbtools;

import database.constants.DBConstants;
import database.utils.DBProvider;

import java.util.Iterator;

public class DB {
    public static void main(String args[]) {
        if(args.length == 1)
            DBConstants.URL = args[0];
        
        DBProvider provider = new DBProvider();

        Iterator it = provider.getAllTables().iterator();
        while (it.hasNext()) {
            String tmp = it.next() + "";
            if(!(tmp.contains("databasechangelog") || tmp.contains("hibernate")))
            provider.executeRawSQL("DROP TABLE " + tmp + " CASCADE");
        }

    }
}
