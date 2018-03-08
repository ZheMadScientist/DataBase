package wrapper.database;

import wrapper.utils.DBProvider;

import java.util.Iterator;

public class DB {
    public static void main(String args[]) {
        DBProvider provider = new DBProvider();

        Iterator it = provider.getAllTables().iterator();
        while (it.hasNext())
            provider.executeRawSQL("DROP TABLE " + it.next());

    }
}
