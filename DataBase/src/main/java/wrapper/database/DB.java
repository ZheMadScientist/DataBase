package wrapper.database;

import wrapper.utils.DBProvider;

public class DB {
    public static void main(String args[]) {
        DBProvider provider = new DBProvider();

        provider.executeRawSQL("DROP TABLE THESAURUS");

        String createThesaurus = "CREATE TABLE THESAURUS " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " GUID           bigint  NOT NULL," +
                " name           text    NOT NULL," +
                " sense          text    NOT NULL," +
                " comments       text)";

        provider.executeRawSQL(createThesaurus);
    }
}
