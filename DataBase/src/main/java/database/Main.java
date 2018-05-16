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
            System.setProperty("spring.datasource.url", "jdbc:postgresql://localhost:5432/EduProcessBank");
            System.setProperty("spring.datasource.username", "postgres");
            System.setProperty("spring.datasource.password", "qwerty");
        }

        System.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.PostgreSQLDialect");
        System.setProperty("spring.jpa.hibernate.ddl-auto", "update");
        System.setProperty("liquibase.change-log", "classpath:db/liquibase-changelog.xml");
        System.setProperty("spring.datasource.driverClassName", "org.postgresql.Driver");
        System.setProperty("hibernate.cache.use_second_level_cache", "false");

        SpringApplication.run(Main.class, args);

    }
}
