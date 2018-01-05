package ru.compscience.database.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBProvider {
    private static String TYPE_INT = "int";
    private static String TYPE_STRING = "String";
    private static String TYPE_URL = "url";

    Connection c;

    private Logger log;

    public DBProvider() {
        log = Logger.getLogger(DBProvider.class.getName());
    }

    private void connect(boolean isAutoCommit) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/EduProcessBank",
                        "postgres",
                        "qwerty");
        if(!isAutoCommit)
            c.setAutoCommit(false);

        log.log(Level.INFO, "Successfully connected to database ");
    }

    public boolean executeRawSQL(String sql) {
        try {
            connect(true);
            Statement statement = c.createStatement();

            statement.execute(sql);
            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean executeUpdRawSQL(String sql) {
        try {
            connect(true);
            Statement statement = c.createStatement();

            statement.executeUpdate(sql);

            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insert(ArrayList<String> sql){
        try {
            connect(false);
            Statement statement = c.createStatement();

            for(String cmd : sql) {
                statement.executeUpdate(cmd);
            }

            statement.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    //           <id in table, table's field>                       <field type , id in table>
    public List< Pair <String, Object> > select (String from, List< Pair <String, String> > fields){
        ArrayList< Pair <String, Object> > selected = new ArrayList<>();
        try {
            connect(false);
            Statement statement = c.createStatement();

            String query = "SELECT * FROM "
                    + from + ";";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                for( Pair <String, String> pair : fields){
                    if(pair.first.equals(TYPE_INT)){
                        selected.add(new Pair<>(pair.second, new Integer(resultSet.getInt(pair.second))));
                    }
                    else if(pair.first.equals(TYPE_STRING)){
                        selected.add(new Pair<>(pair.second, resultSet.getString(pair.second)));
                    }
                    else if(pair.first.equals(TYPE_URL)){
                        selected.add(new Pair<>(pair.second, resultSet.getURL(pair.second)));
                    }
                }
            }

            resultSet.close();
            statement.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return selected;
    }

    public boolean update(String from, String field, String value, String extra){
        String cmd = "UPDATE " +
                from +
                " set " +
                field.toUpperCase() +
                " = " +
                value;
        if(!extra.equals(""))
            cmd += " " + extra;

        try {
            connect(true);
            Statement statement = c.createStatement();

            statement.executeUpdate(cmd);

            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean delete(String from, String sql){
        String cmd = "DELETE from " +
                from +
                " " +
                sql;

        try {
            connect(true);
            Statement statement = c.createStatement();

            statement.executeUpdate(cmd);

            statement.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
