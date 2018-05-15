package database;

import database.constants.DBConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Точка входа для приложения
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        if(args.length == 5){
            System.setProperty("spring.datasource.url", args[0]);
            System.setProperty("spring.datasource.username", args[1]);
            System.setProperty("spring.datasource.password", args[2]);
            System.setProperty("server.port", args[3]);

            DBConstants.URL = args[0];
            DBConstants.USERNAME = args[1];
            DBConstants.PASSWORD = args[2];

        } else {
            System.out.println("Running with default settings");
        }
        SpringApplication.run(Main.class, args);

    }
}
