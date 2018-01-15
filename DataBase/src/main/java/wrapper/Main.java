package wrapper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import wrapper.api.DBProvider;
import wrapper.model.Item;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class , HibernateJpaAutoConfiguration.class})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        final String uri = "http://localhost:8080/item";

        Item item = new DBProvider(uri).getItem();
        System.out.println(item.id + " " + item.name);
    }

}
