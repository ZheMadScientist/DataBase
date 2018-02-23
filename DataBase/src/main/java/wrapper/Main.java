package wrapper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import wrapper.api.DBProvider;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);



        final String uri = "http://localhost:8080/item";

        //Item item = new DBProvider(uri).getItem();
        //System.out.println(item.id + " " + item.name);
    }

    /*@Bean
    public WebMvcConfigurer corsConfigurer() {
        System.out.println("-----------------------------corsConfigurer---------------------------");
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/item-assesconfig").allowedOrigins();
            }
        };
    }*/

}
