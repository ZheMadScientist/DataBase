package ru.compscience.database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBProvider {
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

    public boolean executeSQL(String sql) {
        try {
            connect(true);
            Statement statement = c.createStatement();

            statement.execute(sql);
            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean executeUpdSQL(String sql) {
        try {
            connect(true);
            Statement statement = c.createStatement();

            statement.executeUpdate(sql);

            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
}
